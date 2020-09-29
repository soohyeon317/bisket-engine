package com.bisket.engine.service;

import com.bisket.engine.domain.BusinessUpdateHistory;
import com.bisket.engine.repository.BusinessRepository;
import com.bisket.engine.constant.BusinessCategory;
import com.bisket.engine.constant.FileExtension;
import com.bisket.engine.domain.Business;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
@Slf4j
public class BusinessService {
    private final String XML_FILE_DIRECTORY_NAME = "business_xml_files";
    private final Pattern XML_FILE_BUSINESS_NAME_PATTERN = Pattern.compile("P_(?<businessCategory>.*).xml");

    private final SafetyOfficinalSaleService safetyOfficinalSaleService;
    private final HospitalService hospitalService;
    private final MedicalCorporationService medicalCorporationService;
    private final ClinicService clinicService;
    private final EmergencyPatientTransferService emergencyPatientTransferService;
    private final PostpartumCareService postpartumCareService;
    private final BusinessUpdateHistoryService businessUpdateHistoryService;

    private final BusinessRepository businessRepository;

    public BusinessService(SafetyOfficinalSaleService safetyOfficinalSaleService, HospitalService hospitalService, MedicalCorporationService medicalCorporationService, ClinicService clinicService, EmergencyPatientTransferService emergencyPatientTransferService, PostpartumCareService postpartumCareService, BusinessUpdateHistoryService businessUpdateHistoryService, BusinessRepository businessRepository) {
        this.safetyOfficinalSaleService = safetyOfficinalSaleService;
        this.hospitalService = hospitalService;
        this.medicalCorporationService = medicalCorporationService;
        this.clinicService = clinicService;
        this.emergencyPatientTransferService = emergencyPatientTransferService;
        this.postpartumCareService = postpartumCareService;
        this.businessUpdateHistoryService = businessUpdateHistoryService;
        this.businessRepository = businessRepository;
    }

    @Async
    @Transactional
    public Integer updateList(FileExtension fileExtension, String targetXmlFileName) {
        Integer updateCountSum = 0;
        BusinessUpdateHistory businessUpdateHistory = null;
        try {
            String resourceFolderPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(
                    String.format("%s", XML_FILE_DIRECTORY_NAME))).getPath();
            File xmlFileResource = new File(resourceFolderPath);
            String[] xmlFileNameArray = xmlFileResource.list();
            List<String> xmlFileNameList = Arrays.asList(Objects.requireNonNull(xmlFileNameArray));
            if (!xmlFileNameList.isEmpty()) {
                switch (fileExtension) {
                    case XML:
                        if (targetXmlFileName == null) {
                            /* 모든 업종을 대상으로 업데이트 */
                            for (int i = 0; i < xmlFileNameArray.length; i++) {
                                String fileName = xmlFileNameArray[i];
                                Matcher businessCategoryMatcher = XML_FILE_BUSINESS_NAME_PATTERN.matcher(fileName);
                                if (businessCategoryMatcher.find()) {
                                    String businessCategoryName = businessCategoryMatcher.group("businessCategory");
                                    String filePath = String.format("%s/%s", resourceFolderPath, fileName);
                                    // 업체업데이트히스토리 기본 정보 세팅
                                    businessUpdateHistory = new BusinessUpdateHistory();
                                    // 업데이트
                                    Integer updateCount = safetyOfficinalSaleService.updateListFromXmlFile(filePath);
                                    // 업체업데이트히스토리 정보 저장
                                    businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                    businessUpdateHistory.setSuccessFlag(true);
                                    businessUpdateHistory.setDataCount(updateCount);
                                    businessUpdateHistoryService.createOne(businessUpdateHistory);
                                    // 업데이트 총 개수 누적
                                    updateCountSum += updateCount;
                                }
                            }
                        } else {
                            /* 특정 업종을 대상으로 업데이트 */
                            // 업체업데이트히스토리 정보 세팅
                            businessUpdateHistory = new BusinessUpdateHistory();
                            for (int i = 0; i < xmlFileNameArray.length; i++) {
                                String fileName = xmlFileNameArray[i];
                                if (fileName.equals(targetXmlFileName)) {
                                    Matcher businessCategoryMatcher = XML_FILE_BUSINESS_NAME_PATTERN.matcher(fileName);
                                    if (businessCategoryMatcher.find()) {
                                        String businessCategoryName = businessCategoryMatcher.group("businessCategory");
                                        String filePath = String.format("%s/%s", resourceFolderPath, fileName);
                                        BusinessCategory businessCategory = BusinessCategory.getByCode(businessCategoryName);
                                        Integer updateCount = null;
                                        switch (businessCategory) {
                                            case SAFETY_OFFICINAL_SALE:
                                                // 업데이트
                                                updateCount = safetyOfficinalSaleService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case HOSPITAL:
                                                // 업데이트
                                                updateCount = hospitalService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MEDICAL_CORPORATION:
                                                // 업데이트
                                                updateCount = medicalCorporationService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case CLINIC:
                                                // 업데이트
                                                updateCount = clinicService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case EMERGENCY_PATIENT_TRANSFER:
                                                // 업데이트
                                                updateCount = emergencyPatientTransferService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case POSTPARTUM_CARE:
                                                // 업데이트
                                                updateCount = postpartumCareService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategory(businessCategoryName);
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            default:
                                                throw new NotFoundException("Business Category - NotFoundException");
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        throw new InvalidParameterException("File Extension - InvalidParameterException");
                }
            } else {
                throw new FileNotFoundException("Xml File Resource - FileNotFoundException");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("=======\n{}", e.getMessage());
            // 업체명은 있지만 업데이트 실패 시에는 업체업데이트히스토리 정보 저장
            if (businessUpdateHistory != null && businessUpdateHistory.getBusinessCategory() != null) {
                businessUpdateHistoryService.createOne(businessUpdateHistory);
            }
            // TODO: 업데이트 오류 알림 구현
        }
        // TODO: 업데이트 작업 종료 알림 구현

        return updateCountSum;
    }

    public List<Business> getList() {
        return businessRepository.findAll();
    }

    public Business getOneById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }
}

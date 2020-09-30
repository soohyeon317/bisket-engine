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
    private final PharmacyService pharmacyService;
    private final SimilarMedicalTreatmentService similarMedicalTreatmentService;
    private final GlassesService glassesService;
    private final MedicalOrganizationLaundryProcessingService medicalOrganizationLaundryProcessingService;
    private final MedicalDeviceSaleLeaseService medicalDeviceSaleLeaseService;
    private final MedicalDeviceRepairService medicalDeviceRepairService;
    private final DentalLaboratoryService dentalLaboratoryService;
    private final BusinessUpdateHistoryService businessUpdateHistoryService;

    private final BusinessRepository businessRepository;

    public BusinessService(SafetyOfficinalSaleService safetyOfficinalSaleService, HospitalService hospitalService, MedicalCorporationService medicalCorporationService, ClinicService clinicService, EmergencyPatientTransferService emergencyPatientTransferService, PostpartumCareService postpartumCareService, PharmacyService pharmacyService, SimilarMedicalTreatmentService similarMedicalTreatmentService, GlassesService glassesService, MedicalOrganizationLaundryProcessingService medicalOrganizationLaundryProcessingService, MedicalDeviceSaleLeaseService medicalDeviceSaleLeaseService, MedicalDeviceRepairService medicalDeviceRepairService, DentalLaboratoryService dentalLaboratoryService, BusinessUpdateHistoryService businessUpdateHistoryService, BusinessRepository businessRepository) {
        this.safetyOfficinalSaleService = safetyOfficinalSaleService;
        this.hospitalService = hospitalService;
        this.medicalCorporationService = medicalCorporationService;
        this.clinicService = clinicService;
        this.emergencyPatientTransferService = emergencyPatientTransferService;
        this.postpartumCareService = postpartumCareService;
        this.pharmacyService = pharmacyService;
        this.similarMedicalTreatmentService = similarMedicalTreatmentService;
        this.glassesService = glassesService;
        this.medicalOrganizationLaundryProcessingService = medicalOrganizationLaundryProcessingService;
        this.medicalDeviceSaleLeaseService = medicalDeviceSaleLeaseService;
        this.medicalDeviceRepairService = medicalDeviceRepairService;
        this.dentalLaboratoryService = dentalLaboratoryService;
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
                                    BusinessCategory businessCategory = BusinessCategory.getByCode(businessCategoryName);
                                    String filePath = String.format("%s/%s", resourceFolderPath, fileName);
                                    // 업체업데이트히스토리 기본 정보 세팅
                                    businessUpdateHistory = new BusinessUpdateHistory();
                                    // 업데이트
                                    Integer updateCount;
                                    switch (Objects.requireNonNull(businessCategory)) {
                                        case SAFETY_OFFICINAL_SALE:
                                            updateCount = safetyOfficinalSaleService.updateListFromXmlFile(filePath);
                                            break;
                                        case HOSPITAL:
                                            updateCount = hospitalService.updateListFromXmlFile(filePath);
                                            break;
                                        case MEDICAL_CORPORATION:
                                            updateCount = medicalCorporationService.updateListFromXmlFile(filePath);
                                            break;
                                        case CLINIC:
                                            updateCount = clinicService.updateListFromXmlFile(filePath);
                                            break;
                                        case EMERGENCY_PATIENT_TRANSFER:
                                            updateCount = emergencyPatientTransferService.updateListFromXmlFile(filePath);
                                            break;
                                        case POSTPARTUM_CARE:
                                            updateCount = postpartumCareService.updateListFromXmlFile(filePath);
                                            break;
                                        case PHARMACY:
                                            updateCount = pharmacyService.updateListFromXmlFile(filePath);
                                            break;
                                        case SIMILAR_MEDICAL_TREATMENT:
                                            updateCount = similarMedicalTreatmentService.updateListFromXmlFile(filePath);
                                            break;
                                        case GLASSES:
                                            updateCount = glassesService.updateListFromXmlFile(filePath);
                                            break;
                                        case MEDICAL_ORGANIZATION_LAUNDRY_PROCESSING:
                                            updateCount = medicalOrganizationLaundryProcessingService.updateListFromXmlFile(filePath);
                                            break;
                                        case MEDICAL_DEVICE_SALE_LEASE:
                                            updateCount = medicalDeviceSaleLeaseService.updateListFromXmlFile(filePath);
                                            break;
                                        case MEDICAL_DEVICE_REPAIR:
                                            updateCount = medicalDeviceRepairService.updateListFromXmlFile(filePath);
                                            break;
                                        case DENTAL_LAB:
                                            updateCount = dentalLaboratoryService.updateListFromXmlFile(filePath);
                                            break;
                                        default:
                                            throw new NotFoundException("Business Category - NotFoundException");
                                    }
                                    // 업데이트 총 개수 누적
                                    updateCountSum += updateCount;
                                    // 업체업데이트히스토리 정보 저장
                                    businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                    businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                    businessUpdateHistory.setSuccessFlag(true);
                                    businessUpdateHistory.setDataCount(updateCount);
                                    businessUpdateHistoryService.createOne(businessUpdateHistory);
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
                                        switch (Objects.requireNonNull(businessCategory)) {
                                            case SAFETY_OFFICINAL_SALE:
                                                // 업데이트
                                                updateCount = safetyOfficinalSaleService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case PHARMACY:
                                                // 업데이트
                                                updateCount = pharmacyService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case SIMILAR_MEDICAL_TREATMENT:
                                                // 업데이트
                                                updateCount = similarMedicalTreatmentService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case GLASSES:
                                                // 업데이트
                                                updateCount = glassesService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MEDICAL_ORGANIZATION_LAUNDRY_PROCESSING:
                                                // 업데이트
                                                updateCount = medicalOrganizationLaundryProcessingService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MEDICAL_DEVICE_SALE_LEASE:
                                                // 업데이트
                                                updateCount = medicalDeviceSaleLeaseService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MEDICAL_DEVICE_REPAIR:
                                                // 업데이트
                                                updateCount = medicalDeviceRepairService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case DENTAL_LAB:
                                                // 업데이트
                                                updateCount = dentalLaboratoryService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
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
            if (businessUpdateHistory != null && businessUpdateHistory.getBusinessCategoryName() != null) {
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

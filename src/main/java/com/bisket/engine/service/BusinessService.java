package com.bisket.engine.service;

import com.bisket.engine.common.BusinessCategory;
import com.bisket.engine.common.FileExtension;
import com.bisket.engine.entity.Business;
import com.bisket.engine.entity.BusinessUpdateHistory;
import com.bisket.engine.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.io.File;
import java.nio.file.NoSuchFileException;
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

    private final BusinessServiceFactory businessServiceFactory;
    private final BusinessUpdateHistoryService businessUpdateHistoryService;

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessServiceFactory businessServiceFactory, BusinessUpdateHistoryService businessUpdateHistoryService, BusinessRepository businessRepository) {
        this.businessServiceFactory = businessServiceFactory;
        this.businessUpdateHistoryService = businessUpdateHistoryService;
        this.businessRepository = businessRepository;
    }

    @Async
    @Transactional
    public Integer updateList(FileExtension fileExtension, String targetXmlFileName) {
        Integer updateCountSum = 0;
        BusinessUpdateHistory businessUpdateHistory = null;
        try {
            String resourceFolderPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(XML_FILE_DIRECTORY_NAME)).getPath();
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
                                    String businessLineName = businessCategoryMatcher.group("businessCategory");
                                    BusinessCategory businessCategory = BusinessCategory.getByCode(businessLineName);
                                    String filePath = String.format("%s/%s", resourceFolderPath, fileName);
                                    // 업체업데이트히스토리 기본 정보 세팅
                                    businessUpdateHistory = new BusinessUpdateHistory();
                                    // 업데이트
                                    BusinessBaseService businessBaseService = businessServiceFactory.getOneBusinessCategoryService(businessCategory);
                                    Integer updateCount = businessBaseService.updateListFromXmlFile(filePath);
                                    // 업데이트 총 개수 누적
                                    updateCountSum += updateCount;
                                    // 업체업데이트히스토리 정보 저장
                                    businessUpdateHistory.setBusinessCategoryName(businessLineName);
                                    businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessLineName)).name());
                                    businessUpdateHistory.setSuccessFlag(true);
                                    businessUpdateHistory.setDataCount(updateCount);
                                    businessUpdateHistoryService.createOne(businessUpdateHistory);
                                }
                            }
                        } else {
                            /* 특정 업종을 대상으로 업데이트 */
                            // 업체업데이트히스토리 정보 세팅
                            businessUpdateHistory = new BusinessUpdateHistory();
                            if (xmlFileNameList.contains(targetXmlFileName)) {
                                for (int i = 0; i < xmlFileNameArray.length; i++) {
                                    String fileName = xmlFileNameArray[i];
                                    if (fileName.equals(targetXmlFileName)) {
                                        Matcher businessCategoryMatcher = XML_FILE_BUSINESS_NAME_PATTERN.matcher(fileName);
                                        if (businessCategoryMatcher.find()) {
                                            String businessLineName = businessCategoryMatcher.group("businessCategory");
                                            String filePath = String.format("%s/%s", resourceFolderPath, fileName);
                                            BusinessCategory businessCategory = BusinessCategory.getByCode(businessLineName);
                                            BusinessBaseService businessBaseService = businessServiceFactory.getOneBusinessCategoryService(businessCategory);
                                            // 업데이트
                                            Integer updateCount = businessBaseService.updateListFromXmlFile(filePath);
                                            // 업체업데이트히스토리 저장
                                            businessUpdateHistory.setBusinessCategoryName(businessLineName);
                                            businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessLineName)).name());
                                            businessUpdateHistory.setSuccessFlag(true);
                                            businessUpdateHistory.setDataCount(updateCount);
                                            businessUpdateHistoryService.createOne(businessUpdateHistory);
                                            // 업데이트 개수 누적
                                            updateCountSum += updateCount;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                throw new NoSuchFileException("Xml File Resource - NoSuchFileException");
                            }
                        }
                        break;
                    default:
                        throw new InvalidParameterException("File Extension - InvalidParameterException");
                }
            } else {
                throw new NoResultException("Xml File Resource - NoResultException");
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

        log.info("=======업체 업데이트 작업 종료=======");

        return updateCountSum;
    }

    public List<Business> getList() {
        return businessRepository.findAll();
    }

    public Business getOneById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }
}

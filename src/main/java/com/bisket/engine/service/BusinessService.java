package com.bisket.engine.service;

import com.bisket.engine.common.BusinessCategory;
import com.bisket.engine.common.FileExtension;
import com.bisket.engine.domain.Business;
import com.bisket.engine.domain.BusinessUpdateHistory;
import com.bisket.engine.repository.BusinessRepository;
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
    private final AnimalHospitalService animalHospitalService;
    private final AnimalPharmacyService animalPharmacyService;
    private final SlaughterService slaughterService;
    private final IncubationService incubationService;
    private final AnimalMedicalEquipmentSaleService animalMedicalEquipmentSaleService;
    private final FeedProductionService feedProductionService;
    private final LivestockArtificialInseminationCenterService livestockArtificialInseminationCenterService;
    private final AnimalFuneralService animalFuneralService;
    private final AnimalSaleService animalSaleService;
    private final LivestockBreedingService livestockBreedingService;
    private final MilkCollectionService milkCollectionService;
    private final LivestockProductTransportService livestockProductTransportService;
    private final LivestockProductStorageService livestockProductStorageService;
    private final LivestockSaleService livestockSaleService;
    private final LivestockProcessingService livestockProcessingService;
    private final AnimalMedicineWholesaleStoreService animalMedicineWholesaleStoreService;
    private final MeatPackagingProcessingService meatPackagingProcessingService;
    private final LivestockFarmingService livestockFarmingService;
    private final CompositeVideoServiceService compositeVideoServiceService;
    private final BusinessUpdateHistoryService businessUpdateHistoryService;

    private final BusinessRepository businessRepository;

    public BusinessService(SafetyOfficinalSaleService safetyOfficinalSaleService, HospitalService hospitalService, MedicalCorporationService medicalCorporationService, ClinicService clinicService, EmergencyPatientTransferService emergencyPatientTransferService, PostpartumCareService postpartumCareService, PharmacyService pharmacyService, SimilarMedicalTreatmentService similarMedicalTreatmentService, GlassesService glassesService, MedicalOrganizationLaundryProcessingService medicalOrganizationLaundryProcessingService, MedicalDeviceSaleLeaseService medicalDeviceSaleLeaseService, MedicalDeviceRepairService medicalDeviceRepairService, DentalLaboratoryService dentalLaboratoryService, AnimalHospitalService animalHospitalService, AnimalPharmacyService animalPharmacyService, SlaughterService slaughterService, IncubationService incubationService, AnimalMedicalEquipmentSaleService animalMedicalEquipmentSaleService, FeedProductionService feedProductionService, LivestockArtificialInseminationCenterService livestockArtificialInseminationCenterService, AnimalFuneralService animalFuneralService, AnimalSaleService animalSaleService, LivestockBreedingService livestockBreedingService, MilkCollectionService milkCollectionService, LivestockProductTransportService livestockProductTransportService, LivestockProductStorageService livestockProductStorageService, LivestockSaleService livestockSaleService, LivestockProcessingService livestockProcessingService, AnimalMedicineWholesaleStoreService animalMedicineWholesaleStoreService, MeatPackagingProcessingService meatPackagingProcessingService, LivestockFarmingService livestockFarmingService, CompositeVideoServiceService compositeVideoServiceService, BusinessUpdateHistoryService businessUpdateHistoryService, BusinessRepository businessRepository) {
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
        this.animalHospitalService = animalHospitalService;
        this.animalPharmacyService = animalPharmacyService;
        this.slaughterService = slaughterService;
        this.incubationService = incubationService;
        this.animalMedicalEquipmentSaleService = animalMedicalEquipmentSaleService;
        this.feedProductionService = feedProductionService;
        this.livestockArtificialInseminationCenterService = livestockArtificialInseminationCenterService;
        this.animalFuneralService = animalFuneralService;
        this.animalSaleService = animalSaleService;
        this.livestockBreedingService = livestockBreedingService;
        this.milkCollectionService = milkCollectionService;
        this.livestockProductTransportService = livestockProductTransportService;
        this.livestockProductStorageService = livestockProductStorageService;
        this.livestockSaleService = livestockSaleService;
        this.livestockProcessingService = livestockProcessingService;
        this.animalMedicineWholesaleStoreService = animalMedicineWholesaleStoreService;
        this.meatPackagingProcessingService = meatPackagingProcessingService;
        this.livestockFarmingService = livestockFarmingService;
        this.compositeVideoServiceService = compositeVideoServiceService;
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
                                        case DENTAL_LABORATORY:
                                            updateCount = dentalLaboratoryService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_HOSPITAL:
                                            updateCount = animalHospitalService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_PHARMACY:
                                            updateCount = animalPharmacyService.updateListFromXmlFile(filePath);
                                            break;
                                        case SLAUGHTER:
                                            updateCount = slaughterService.updateListFromXmlFile(filePath);
                                            break;
                                        case INCUBATION:
                                            updateCount = incubationService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_MEDICAL_EQUIPMENT_SALE:
                                            updateCount = animalMedicalEquipmentSaleService.updateListFromXmlFile(filePath);
                                            break;
                                        case FEED_PRODUCTION:
                                            updateCount = feedProductionService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_ARTIFICIAL_INSEMINATION_CENTER:
                                            updateCount = livestockArtificialInseminationCenterService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_FUNERAL:
                                            updateCount = animalFuneralService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_SALE:
                                            updateCount = animalSaleService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_BREEDING:
                                            updateCount = livestockBreedingService.updateListFromXmlFile(filePath);
                                            break;
                                        case MILK_COLLECTION:
                                            updateCount = milkCollectionService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_PRODUCT_TRANSPORT:
                                            updateCount = livestockProductTransportService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_PRODUCT_STORAGE:
                                            updateCount = livestockProductStorageService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_SALE:
                                            updateCount = livestockSaleService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_PROCESSING:
                                            updateCount = livestockProcessingService.updateListFromXmlFile(filePath);
                                            break;
                                        case ANIMAL_MEDICINE_WHOLESALE_STORE:
                                            updateCount = animalMedicineWholesaleStoreService.updateListFromXmlFile(filePath);
                                            break;
                                        case MEAT_PACKAGING_PROCESSING:
                                            updateCount = meatPackagingProcessingService.updateListFromXmlFile(filePath);
                                            break;
                                        case LIVESTOCK_FARMING:
                                            updateCount = livestockFarmingService.updateListFromXmlFile(filePath);
                                            break;
                                        case COMPOSITE_VIDEO_SERVICE:
                                            updateCount = compositeVideoServiceService.updateListFromXmlFile(filePath);
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
                                            case DENTAL_LABORATORY:
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
                                            case ANIMAL_HOSPITAL:
                                                // 업데이트
                                                updateCount = animalHospitalService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case ANIMAL_PHARMACY:
                                                // 업데이트
                                                updateCount = animalPharmacyService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case SLAUGHTER:
                                                // 업데이트
                                                updateCount = slaughterService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case INCUBATION:
                                                // 업데이트
                                                updateCount = incubationService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case ANIMAL_MEDICAL_EQUIPMENT_SALE:
                                                // 업데이트
                                                updateCount = animalMedicalEquipmentSaleService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case FEED_PRODUCTION:
                                                // 업데이트
                                                updateCount = feedProductionService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_ARTIFICIAL_INSEMINATION_CENTER:
                                                // 업데이트
                                                updateCount = livestockArtificialInseminationCenterService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case ANIMAL_FUNERAL:
                                                // 업데이트
                                                updateCount = animalFuneralService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case ANIMAL_SALE:
                                                // 업데이트
                                                updateCount = animalSaleService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_BREEDING:
                                                // 업데이트
                                                updateCount = livestockBreedingService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MILK_COLLECTION:
                                                // 업데이트
                                                updateCount = milkCollectionService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_PRODUCT_TRANSPORT:
                                                // 업데이트
                                                updateCount = livestockProductTransportService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_PRODUCT_STORAGE:
                                                // 업데이트
                                                updateCount = livestockProductStorageService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_SALE:
                                                // 업데이트
                                                updateCount = livestockSaleService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_PROCESSING:
                                                // 업데이트
                                                updateCount = livestockProcessingService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case ANIMAL_MEDICINE_WHOLESALE_STORE:
                                                // 업데이트
                                                updateCount = animalMedicineWholesaleStoreService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case MEAT_PACKAGING_PROCESSING:
                                                // 업데이트
                                                updateCount = meatPackagingProcessingService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case LIVESTOCK_FARMING:
                                                // 업데이트
                                                updateCount = livestockFarmingService.updateListFromXmlFile(filePath);
                                                // 업체업데이트히스토리 저장
                                                businessUpdateHistory.setBusinessCategoryName(businessCategoryName);
                                                businessUpdateHistory.setBusinessCategoryTableName(Objects.requireNonNull(BusinessCategory.getByCode(businessCategoryName)).name());
                                                businessUpdateHistory.setSuccessFlag(true);
                                                businessUpdateHistory.setDataCount(updateCount);
                                                businessUpdateHistoryService.createOne(businessUpdateHistory);
                                                // 업데이트 개수 누적
                                                updateCountSum += updateCount;
                                                break;
                                            case COMPOSITE_VIDEO_SERVICE:
                                                // 업데이트
                                                updateCount = compositeVideoServiceService.updateListFromXmlFile(filePath);
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

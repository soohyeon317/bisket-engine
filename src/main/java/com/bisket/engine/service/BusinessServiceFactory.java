package com.bisket.engine.service;

import com.bisket.engine.common.BusinessCategory;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class BusinessServiceFactory {
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
    private final GameDistributionService gameDistributionService;

    public BusinessBaseService getOneBusinessCategoryService(BusinessCategory businessCategory) throws Exception {
        BusinessBaseService businessBaseService;
        switch (Objects.requireNonNull(businessCategory)) {
            case SAFETY_OFFICINAL_SALE:
                businessBaseService = safetyOfficinalSaleService;
                break;
            case HOSPITAL:
                businessBaseService = hospitalService;
                break;
            case MEDICAL_CORPORATION:
                businessBaseService = medicalCorporationService;
                break;
            case CLINIC:
                businessBaseService = clinicService;
                break;
            case EMERGENCY_PATIENT_TRANSFER:
                businessBaseService = emergencyPatientTransferService;
                break;
            case POSTPARTUM_CARE:
                businessBaseService = postpartumCareService;
                break;
            case PHARMACY:
                businessBaseService = pharmacyService;
                break;
            case SIMILAR_MEDICAL_TREATMENT:
                businessBaseService = similarMedicalTreatmentService;
                break;
            case GLASSES:
                businessBaseService = glassesService;
                break;
            case MEDICAL_ORGANIZATION_LAUNDRY_PROCESSING:
                businessBaseService = medicalOrganizationLaundryProcessingService;
                break;
            case MEDICAL_DEVICE_SALE_LEASE:
                businessBaseService = medicalDeviceSaleLeaseService;
                break;
            case MEDICAL_DEVICE_REPAIR:
                businessBaseService = medicalDeviceRepairService;
                break;
            case DENTAL_LABORATORY:
                businessBaseService = dentalLaboratoryService;
                break;
            case ANIMAL_HOSPITAL:
                businessBaseService = animalHospitalService;
                break;
            case ANIMAL_PHARMACY:
                businessBaseService = animalPharmacyService;
                break;
            case SLAUGHTER:
                businessBaseService = slaughterService;
                break;
            case INCUBATION:
                businessBaseService = incubationService;
                break;
            case ANIMAL_MEDICAL_EQUIPMENT_SALE:
                businessBaseService = animalMedicalEquipmentSaleService;
                break;
            case FEED_PRODUCTION:
                businessBaseService = feedProductionService;
                break;
            case LIVESTOCK_ARTIFICIAL_INSEMINATION_CENTER:
                businessBaseService = livestockArtificialInseminationCenterService;
                break;
            case ANIMAL_FUNERAL:
                businessBaseService = animalFuneralService;
                break;
            case ANIMAL_SALE:
                businessBaseService = animalSaleService;
                break;
            case LIVESTOCK_BREEDING:
                businessBaseService = livestockBreedingService;
                break;
            case MILK_COLLECTION:
                businessBaseService = milkCollectionService;
                break;
            case LIVESTOCK_PRODUCT_TRANSPORT:
                businessBaseService = livestockProductTransportService;
                break;
            case LIVESTOCK_PRODUCT_STORAGE:
                businessBaseService = livestockProductStorageService;
                break;
            case LIVESTOCK_SALE:
                businessBaseService = livestockSaleService;
                break;
            case LIVESTOCK_PROCESSING:
                businessBaseService = livestockProcessingService;
                break;
            case ANIMAL_MEDICINE_WHOLESALE_STORE:
                businessBaseService = animalMedicineWholesaleStoreService;
                break;
            case MEAT_PACKAGING_PROCESSING:
                businessBaseService = meatPackagingProcessingService;
                break;
            case LIVESTOCK_FARMING:
                businessBaseService = livestockFarmingService;
                break;
            case COMPOSITE_VIDEO_SERVICE:
                businessBaseService = compositeVideoServiceService;
                break;
            case GAME_DISTRIBUTION:
                businessBaseService = gameDistributionService;
                break;
            default:
                throw new NotFoundException("Business Category - NotFoundException");
        }

        return businessBaseService;
    }
}

package com.bisket.engine.service;

import com.bisket.engine.common.BusinessCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class BusinessServiceFactory {
    private final SafetyOfficinalSaleService safetyOfficinalSaleService;
    private final HospitalService hospitalService;
    private final MedicalCorporationService medicalCorporationService;
    private final ClinicService clinicService;
    private final EmergencyPatientTransferService emergencyPatientTransferService;
    private final AffiliatedMedicalOrganizationService affiliatedMedicalOrganizationService;
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
    private final GameProductionService gameProductionService;
    private final PrintingService printingService;
    private final PublishingService publishingService;
    private final MovieProductionService movieProductionService;
    private final MovieScreeningService movieScreeningService;
    private final MovieImportService movieImportService;
    private final MovieTheaterService movieTheaterService;
    private final VideoProductionService videoProductionService;
    private final MovieDistributionService movieDistributionService;
    private final VideoWatchingServiceService videoWatchingServiceService;
    private final VideoLittleTheaterService videoLittleTheaterService;
    private final VideoDistributionService videoDistributionService;
    private final VideoRoomService videoRoomService;
    private final SingingRoomService singingRoomService;
    private final TeenagerGameServiceService teenagerGameServiceService;
    private final GeneralGameServiceService generalGameServiceService;
    private final InternetComputerGameFacilityServiceService internetComputerGameFacilityServiceService;
    private final CompositeDistributionGameServiceService compositeDistributionGameServiceService;
    private final PopularCultureArtsPlanningService popularCultureArtsPlanningService;
    private final OnlineMusicServiceService onlineMusicServiceService;
    private final MusicRecordVideoDistributionService musicRecordVideoDistributionService;
    private final MusicRecordProductionService musicRecordProductionService;
    private final MusicRecordDistributionService musicRecordDistributionService;
    private final MusicRecordVideoProductionService musicRecordVideoProductionService;

    public BusinessBaseService getOneBusinessCategoryService(BusinessCategory businessCategory) throws NoSuchObjectException {
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
            case AFFILIATED_MEDICAL_ORGANIZATION:
                businessBaseService = affiliatedMedicalOrganizationService;
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
            case GAME_PRODUCTION:
                businessBaseService = gameProductionService;
                break;
            case PRINTING:
                businessBaseService = printingService;
                break;
            case PUBLISHING:
                businessBaseService = publishingService;
                break;
            case MOVIE_PRODUCTION:
                businessBaseService = movieProductionService;
                break;
            case MOVIE_SCREENING:
                businessBaseService = movieScreeningService;
                break;
            case MOVIE_IMPORT:
                businessBaseService = movieImportService;
                break;
            case MOVIE_THEATER:
                businessBaseService = movieTheaterService;
                break;
            case VIDEO_PRODUCTION:
                businessBaseService = videoProductionService;
                break;
            case MOVIE_DISTRIBUTION:
                businessBaseService = movieDistributionService;
                break;
            case VIDEO_WATCHING_SERVICE:
                businessBaseService = videoWatchingServiceService;
                break;
            case VIDEO_LITTLE_THEATER:
                businessBaseService = videoLittleTheaterService;
                break;
            case VIDEO_DISTRIBUTION:
                businessBaseService = videoDistributionService;
                break;
            case VIDEO_ROOM:
                businessBaseService = videoRoomService;
                break;
            case SINGING_ROOM:
                businessBaseService = singingRoomService;
                break;
            case TEENAGER_GAME_SERVICE:
                businessBaseService = teenagerGameServiceService;
                break;
            case GENERAL_GAME_SERVICE:
                businessBaseService = generalGameServiceService;
                break;
            case INTERNET_COMPUTER_GAME_FACILITY_SERVICE:
                businessBaseService = internetComputerGameFacilityServiceService;
                break;
            case COMPOSITE_DISTRIBUTION_GAME_SERVICE:
                businessBaseService = compositeDistributionGameServiceService;
                break;
            case POPULAR_CULTURE_ARTS_PLANNING:
                businessBaseService = popularCultureArtsPlanningService;
                break;
            case ONLINE_MUSIC_SERVICE:
                businessBaseService = onlineMusicServiceService;
                break;
            case MUSIC_RECORD_VIDEO_DISTRIBUTION:
                businessBaseService = musicRecordVideoDistributionService;
                break;
            case MUSIC_RECORD_PRODUCTION:
                businessBaseService = musicRecordProductionService;
                break;
            case MUSIC_RECORD_DISTRIBUTION:
                businessBaseService = musicRecordDistributionService;
                break;
            case MUSIC_RECORD_VIDEO_PRODUCTION:
                businessBaseService = musicRecordVideoProductionService;
                break;
            default:
                throw new NoSuchObjectException("Business Category - NoSuchObjectException");
        }

        return businessBaseService;
    }
}

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
    private final FeedManufacturingService feedManufacturingService;
    private final LivestockArtificialInseminationCenterService livestockArtificialInseminationCenterService;
    private final AnimalFuneralService animalFuneralService;
    private final AnimalSaleService animalSaleService;
    private final BreedingStockService breedingStockService;
    private final MilkCollectionService milkCollectionService;
    private final LivestockProductTransportService livestockProductTransportService;
    private final LivestockProductStorageService livestockProductStorageService;
    private final LivestockSaleService livestockSaleService;
    private final LivestockProcessingService livestockProcessingService;
    private final AnimalMedicineWholesaleStoreService animalMedicineWholesaleStoreService;
    private final MeatPackagingService meatPackagingService;
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
    private final ForeignerTourCityAccommodationService foreignerTourCityAccommodationService;
    private final ForeignerAmusementRestaurantService foreignerAmusementRestaurantService;
    private final DomesticTravelService domesticTravelService;
    private final DowntownCircularTourService downtownCircularTourService;
    private final GeneralAmusementFacilityService generalAmusementFacilityService;
    private final GeneralCampService generalCampService;
    private final GeneralTravelService generalTravelService;
    private final HanokExperienceService hanokExperienceService;
    private final InternationalConferenceFacilityService internationalConferenceFacilityService;
    private final InternationalConferencePlanningService internationalConferencePlanningService;
    private final InternationalTravelService internationalTravelService;
    private final MotorCampService motorCampService;
    private final OtherAmusementFacilityService otherAmusementFacilityService;
    private final OverallAmusementFacilityService overallAmusementFacilityService;
    private final OverallRecreationService overallRecreationService;
    private final SpecializedRecreationService specializedRecreationService;
    private final StageService stageService;
    private final TourAmusementRestaurantService tourAmusementRestaurantService;
    private final TourCruiserService tourCruiserService;
    private final TourBusinessOperatorService tourBusinessOperatorService;
    private final TourPensionService tourPensionService;
    private final TourRestaurantService tourRestaurantService;
    private final TourStageService tourStageService;
    private final TourTheaterAmusementService tourTheaterAmusementService;
    private final TourTrackService tourTrackService;
    private final TourAccommodationService tourAccommodationService;
    private final RestRestaurantService restRestaurantService;
    private final GeneralRestaurantService generalRestaurantService;
    private final BakeryService bakeryService;
    private final ConsignmentFoodServiceService consignmentFoodServiceService;
    private final GroupFoodServiceService groupFoodServiceService;
    private final HealthFunctionalFoodDistributionSaleService healthFunctionalFoodDistributionSaleService;
    private final ContainerWrapperManufacturingService containerWrapperManufacturingService;
    private final AmusementBarService amusementBarService;
    private final KaraokeBarService karaokeBarService;
    private final EdibleIceSaleService edibleIceSaleService;
    private final InstantSaleManufacturingProcessingService instantSaleManufacturingProcessingService;
    private final FoodManufacturingProcessingService foodManufacturingProcessingService;
    private final DistributionSaleService distributionSaleService;
    private final OtherFoodSaleService otherFoodSaleService;
    private final HealthFunctionalFoodGeneralSaleService healthFunctionalFoodGeneralSaleService;
    private final GroupFoodServiceFoodSaleService groupFoodServiceFoodSaleService;
    private final FoodSubdivisionService foodSubdivisionService;
    private final FoodTransportService foodTransportService;
    private final FoodAdditivesManufacturingService foodAdditivesManufacturingService;
    private final FoodRefrigerationService foodRefrigerationService;
    private final FoodVendingMachineService foodVendingMachineService;
    private final PotteryManufacturingService potteryManufacturingService;
    private final RegisteredSportsFacilityService registeredSportsFacilityService;
    private final BilliardRoomService billiardRoomService;
    private final YachtingCourseService yachtingCourseService;
    private final SleddingSlopeService sleddingSlopeService;
    private final SkiResortService skiResortService;
    private final SwimmingPoolService swimmingPoolService;
    private final IceRinkService iceRinkService;
    private final GolfCourseService golfCourseService;
    private final HorseRidingCourseService horseRidingCourseService;
    private final GolfDrivingRangeService golfDrivingRangeService;
    private final MartialArtAcademyService martialArtAcademyService;
    private final MartialArtGymService martialArtGymService;
    private final PhysicalEducationGymService physicalEducationGymService;
    private final PhysicalFitnessCenterService physicalFitnessCenterService;
    private final OtherWaterPollutantInstallationFacilityService otherWaterPollutantInstallationFacilityService;
    private final ExcretaCollectionTransportService excretaCollectionTransportService;
    private final LivestockExcretaCollectionTransportService livestockExcretaCollectionTransportService;
    private final SewageTreatmentFacilityDesignConstructionService sewageTreatmentFacilityDesignConstructionService;
    private final LivestockExcretaDischargeFacilityManagementService livestockExcretaDischargeFacilityManagementService;
    private final AirPollutantDischargeFacilityInstallationService airPollutantDischargeFacilityInstallationService;
    private final DischargeGasMaintenanceCheckAgencyService dischargeGasMaintenanceCheckAgencyService;
    private final IndividualSewageTreatmentFacilityManagementService individualSewageTreatmentFacilityManagementService;
    private final HaircuttingService haircuttingService;
    private final LaundryService laundryService;
    private final BuildingSanitationService buildingSanitationService;
    private final AccommodationService accommodationService;
    private final BeautyService beautyService;
    private final BathhouseService bathhouseService;
    private final EnvironmentalConsultingService environmentalConsultingService;
    private final EnvironmentalMeasurementAgencyService environmentalMeasurementAgencyService;
    private final EnvironmentalManagementAgencyService environmentalManagementAgencyService;
    private final EnvironmentalConstructionService environmentalConstructionService;
    private final TimberImportDistributionService timberImportDistributionService;
    private final LumberingService lumberingService;
    private final HardwoodProductionService hardwoodProductionService;
    private final MeterVerificationService meterVerificationService;
    private final MeterManufacturingService meterManufacturingService;
    private final MeterImportService meterImportService;
    private final MeterRepairService meterRepairService;
    private final HighPressureGasService highPressureGasService;
    private final CoalBriquetteManufacturingService coalBriquetteManufacturingService;
    private final LiquefiedPetroleumGasApplianceManufacturingService liquefiedPetroleumGasApplianceManufacturingService;
    private final GeneralCityGasService generalCityGasService;
    private final MutualAidService mutualAidService;
    private final ElectricTechnologySupervisionService electricTechnologySupervisionService;
    private final ElectricTechnologyDesignService electricTechnologyDesignService;
    private final SpecificPressureGasService specificPressureGasService;
    private final UndergroundWaterConstructionService undergroundWaterConstructionService;
    private final UndergroundWaterPurificationService undergroundWaterPurificationService;
    private final UndergroundWaterImpactAssessmentOrganizationService undergroundWaterImpactAssessmentOrganizationService;
    private final TraditionalTempleService traditionalTempleService;
    private final ContainerFreezerSpecificFacilityService containerFreezerSpecificFacilityService;
    private final WaterSupplyConstructionAgencyService waterSupplyConstructionAgencyService;
    private final DisinfectionService disinfectionService;
    private final BigScaleStoreService bigScaleStoreService;
    private final OverallSportsFacilityService overallSportsFacilityService;
    private final StandardPlasticGarbageBagSaleService standardPlasticGarbageBagSaleService;
    private final WaterStorageTankCleaningService waterStorageTankCleaningService;
    private final ConstructionWasteTreatmentService constructionWasteTreatmentService;
    private final CultureArtsCorporationService cultureArtsCorporationService;
    private final MuseumArtGalleryService museumArtGalleryService;
    private final TobaccoImportSaleService tobaccoImportSaleService;
    private final TobaccoWholesaleService tobaccoWholesaleService;
    private final TobaccoRetailService tobaccoRetailService;
    private final InternationalLogisticsBrokerageService internationalLogisticsBrokerageService;
    private final WarehouseService warehouseService;
    private final CivilDefenceShelterFacilityService civilDefenceShelterFacilityService;
    private final CivilDefenceWaterSupplyFacilityService civilDefenceWaterSupplyFacilityService;
    private final ElevatorManufacturingImportService elevatorManufacturingImportService;
    private final ElevatorMaintenanceService elevatorMaintenanceService;
    private final FuneralDirectorEducationOrganizationService funeralDirectorEducationOrganizationService;
    private final CaregiverEducationOrganizationService caregiverEducationOrganizationService;
    private final FeeChargingEmploymentAgencyService feeChargingEmploymentAgencyService;
    private final FreeEmploymentAgencyService freeEmploymentAgencyService;
    private final AdministrativeAgentService administrativeAgentService;
    private final DoorToDoorSaleService doorToDoorSaleService;
    private final ColdCallingSaleService coldCallingSaleService;
    private final TelemarketingService telemarketingService;
    private final MultilevelSaleService multilevelSaleService;
    private final SponsoredDoorToDoorSaleService sponsoredDoorToDoorSaleService;
    private final LocalCultureCenterService localCultureCenterService;
    private final OutdoorAdvertisingService outdoorAdvertisingService;
    private final PetroleumSaleService petroleumSaleService;
    private final PetroleumAlternativeFuelSaleService petroleumAlternativeFuelSaleService;

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
            case FEED_MANUFACTURING:
                businessBaseService = feedManufacturingService;
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
            case BREEDING_STOCK:
                businessBaseService = breedingStockService;
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
            case MEAT_PACKAGING:
                businessBaseService = meatPackagingService;
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
            case FOREIGNER_TOUR_CITY_ACCOMMODATION:
                businessBaseService = foreignerTourCityAccommodationService;
                break;
            case FOREIGNER_AMUSEMENT_RESTAURANT:
                businessBaseService = foreignerAmusementRestaurantService;
                break;
            case DOMESTIC_TRAVEL:
                businessBaseService = domesticTravelService;
                break;
            case DOWNTOWN_CIRCULAR_TOUR:
                businessBaseService = downtownCircularTourService;
                break;
            case GENERAL_AMUSEMENT_FACILITY:
                businessBaseService = generalAmusementFacilityService;
                break;
            case GENERAL_CAMP:
                businessBaseService = generalCampService;
                break;
            case GENERAL_TRAVEL:
                businessBaseService = generalTravelService;
                break;
            case HANOK_EXPERIENCE:
                businessBaseService = hanokExperienceService;
                break;
            case INTERNATIONAL_CONFERENCE_FACILITY:
                businessBaseService = internationalConferenceFacilityService;
                break;
            case INTERNATIONAL_CONFERENCE_PLANNING:
                businessBaseService = internationalConferencePlanningService;
                break;
            case INTERNATIONAL_TRAVEL:
                businessBaseService = internationalTravelService;
                break;
            case MOTOR_CAMP:
                businessBaseService = motorCampService;
                break;
            case OTHER_AMUSEMENT_FACILITY:
                businessBaseService = otherAmusementFacilityService;
                break;
            case OVERALL_AMUSEMENT_FACILITY:
                businessBaseService = overallAmusementFacilityService;
                break;
            case OVERALL_RECREATION:
                businessBaseService = overallRecreationService;
                break;
            case SPECIALIZED_RECREATION:
                businessBaseService = specializedRecreationService;
                break;
            case STAGE:
                businessBaseService = stageService;
                break;
            case TOUR_AMUSEMENT_RESTAURANT:
                businessBaseService = tourAmusementRestaurantService;
                break;
            case TOUR_CRUISER:
                businessBaseService = tourCruiserService;
                break;
            case TOUR_BUSINESS_OPERATOR:
                businessBaseService = tourBusinessOperatorService;
                break;
            case TOUR_PENSION:
                businessBaseService = tourPensionService;
                break;
            case TOUR_RESTAURANT:
                businessBaseService = tourRestaurantService;
                break;
            case TOUR_STAGE:
                businessBaseService = tourStageService;
                break;
            case TOUR_THEATER_AMUSEMENT:
                businessBaseService = tourTheaterAmusementService;
                break;
            case TOUR_TRACK:
                businessBaseService = tourTrackService;
                break;
            case TOUR_ACCOMMODATION:
                businessBaseService = tourAccommodationService;
                break;
            case REST_RESTAURANT:
                businessBaseService = restRestaurantService;
                break;
            case GENERAL_RESTAURANT:
                businessBaseService = generalRestaurantService;
                break;
            case BAKERY:
                businessBaseService = bakeryService;
                break;
            case CONSIGNMENT_FOOD_SERVICE:
                businessBaseService = consignmentFoodServiceService;
                break;
            case GROUP_FOOD_SERVICE:
                businessBaseService = groupFoodServiceService;
                break;
            case HEALTH_FUNCTIONAL_FOOD_DISTRIBUTION_SALE:
                businessBaseService = healthFunctionalFoodDistributionSaleService;
                break;
            case CONTAINER_WRAPPER_MANUFACTURING:
                businessBaseService = containerWrapperManufacturingService;
                break;
            case AMUSEMENT_BAR:
                businessBaseService = amusementBarService;
                break;
            case KARAOKE_BAR:
                businessBaseService = karaokeBarService;
                break;
            case EDIBLE_ICE_SALE:
                businessBaseService = edibleIceSaleService;
                break;
            case INSTANT_SALE_MANUFACTURING_PROCESSING:
                businessBaseService = instantSaleManufacturingProcessingService;
                break;
            case FOOD_MANUFACTURING_PROCESSING:
                businessBaseService = foodManufacturingProcessingService;
                break;
            case DISTRIBUTION_SALE:
                businessBaseService = distributionSaleService;
                break;
            case OTHER_FOOD_SALE:
                businessBaseService = otherFoodSaleService;
                break;
            case HEALTH_FUNCTIONAL_FOOD_GENERAL_SALE:
                businessBaseService = healthFunctionalFoodGeneralSaleService;
                break;
            case GROUP_FOOD_SERVICE_FOOD_SALE:
                businessBaseService = groupFoodServiceFoodSaleService;
                break;
            case FOOD_SUBDIVISION:
                businessBaseService = foodSubdivisionService;
                break;
            case FOOD_TRANSPORT:
                businessBaseService = foodTransportService;
                break;
            case FOOD_ADDITIVES_MANUFACTURING:
                businessBaseService = foodAdditivesManufacturingService;
                break;
            case FOOD_REFRIGERATION:
                businessBaseService = foodRefrigerationService;
                break;
            case FOOD_VENDING_MACHINE:
                businessBaseService = foodVendingMachineService;
                break;
            case POTTERY_MANUFACTURING:
                businessBaseService = potteryManufacturingService;
                break;
            case REGISTERED_SPORTS_FACILITY:
                businessBaseService = registeredSportsFacilityService;
                break;
            case BILLIARD_ROOM:
                businessBaseService = billiardRoomService;
                break;
            case YACHTING_COURSE:
                businessBaseService = yachtingCourseService;
                break;
            case SLEDDING_SLOPE:
                businessBaseService = sleddingSlopeService;
                break;
            case SKI_RESORT:
                businessBaseService = skiResortService;
                break;
            case SWIMMING_POOL:
                businessBaseService = swimmingPoolService;
                break;
            case ICE_RINK:
                businessBaseService = iceRinkService;
                break;
            case GOLF_COURSE:
                businessBaseService = golfCourseService;
                break;
            case HORSE_RIDING_COURSE:
                businessBaseService = horseRidingCourseService;
                break;
            case GOLF_DRIVING_RANGE:
                businessBaseService = golfDrivingRangeService;
                break;
            case MARTIAL_ART_ACADEMY:
                businessBaseService = martialArtAcademyService;
                break;
            case MARTIAL_ART_GYM:
                businessBaseService = martialArtGymService;
                break;
            case PHYSICAL_EDUCATION_GYM:
                businessBaseService = physicalEducationGymService;
                break;
            case PHYSICAL_FITNESS_CENTER:
                businessBaseService = physicalFitnessCenterService;
                break;
            case OTHER_WATER_POLLUTANT_INSTALLATION_FACILITY:
                businessBaseService = otherWaterPollutantInstallationFacilityService;
                break;
            case EXCRETA_COLLECTION_TRANSPORT:
                businessBaseService = excretaCollectionTransportService;
                break;
            case LIVESTOCK_EXCRETA_COLLECTION_TRANSPORT:
                businessBaseService = livestockExcretaCollectionTransportService;
                break;
            case SEWAGE_TREATMENT_FACILITY_DESIGN_CONSTRUCTION:
                businessBaseService = sewageTreatmentFacilityDesignConstructionService;
                break;
            case LIVESTOCK_EXCRETA_DISCHARGE_FACILITY_MANAGEMENT:
                businessBaseService = livestockExcretaDischargeFacilityManagementService;
                break;
            case AIR_POLLUTANT_DISCHARGE_FACILITY_INSTALLATION:
                businessBaseService = airPollutantDischargeFacilityInstallationService;
                break;
            case DISCHARGE_GAS_MAINTENANCE_CHECK_AGENCY:
                businessBaseService = dischargeGasMaintenanceCheckAgencyService;
                break;
            case INDIVIDUAL_SEWAGE_TREATMENT_FACILITY_MANAGEMENT:
                businessBaseService = individualSewageTreatmentFacilityManagementService;
                break;
            case HAIRCUTTING:
                businessBaseService = haircuttingService;
                break;
            case LAUNDRY:
                businessBaseService = laundryService;
                break;
            case BUILDING_SANITATION:
                businessBaseService = buildingSanitationService;
                break;
            case ACCOMMODATION:
                businessBaseService = accommodationService;
                break;
            case BEAUTY:
                businessBaseService = beautyService;
                break;
            case BATHHOUSE:
                businessBaseService = bathhouseService;
                break;
            case ENVIRONMENTAL_CONSULTING:
                businessBaseService = environmentalConsultingService;
                break;
            case ENVIRONMENTAL_MEASUREMENT_AGENCY:
                businessBaseService = environmentalMeasurementAgencyService;
                break;
            case ENVIRONMENTAL_MANAGEMENT_AGENCY:
                businessBaseService = environmentalManagementAgencyService;
                break;
            case ENVIRONMENTAL_CONSTRUCTION:
                businessBaseService = environmentalConstructionService;
                break;
            case TIMBER_IMPORT_DISTRIBUTION:
                businessBaseService = timberImportDistributionService;
                break;
            case LUMBERING:
                businessBaseService = lumberingService;
                break;
            case HARDWOOD_PRODUCTION:
                businessBaseService = hardwoodProductionService;
                break;
            case METER_VERIFICATION:
                businessBaseService = meterVerificationService;
                break;
            case METER_MANUFACTURING:
                businessBaseService = meterManufacturingService;
                break;
            case METER_IMPORT:
                businessBaseService = meterImportService;
                break;
            case METER_REPAIR:
                businessBaseService = meterRepairService;
                break;
            case HIGH_PRESSURE_GAS:
                businessBaseService = highPressureGasService;
                break;
            case COAL_BRIQUETTE_MANUFACTURING:
                businessBaseService = coalBriquetteManufacturingService;
                break;
            case LIQUEFIED_PETROLEUM_GAS_APPLIANCE_MANUFACTURING:
                businessBaseService = liquefiedPetroleumGasApplianceManufacturingService;
                break;
            case GENERAL_CITY_GAS:
                businessBaseService = generalCityGasService;
                break;
            case MUTUAL_AID:
                businessBaseService = mutualAidService;
                break;
            case ELECTRIC_TECHNOLOGY_SUPERVISION:
                businessBaseService = electricTechnologySupervisionService;
                break;
            case ELECTRIC_TECHNOLOGY_DESIGN:
                businessBaseService = electricTechnologyDesignService;
                break;
            case SPECIFIC_PRESSURE_GAS:
                businessBaseService = specificPressureGasService;
                break;
            case UNDERGROUND_WATER_CONSTRUCTION:
                businessBaseService = undergroundWaterConstructionService;
                break;
            case UNDERGROUND_WATER_PURIFICATION:
                businessBaseService = undergroundWaterPurificationService;
                break;
            case UNDERGROUND_WATER_IMPACT_ASSESSMENT_ORGANIZATION:
                businessBaseService = undergroundWaterImpactAssessmentOrganizationService;
                break;
            case TRADITIONAL_TEMPLE:
                businessBaseService = traditionalTempleService;
                break;
            case CONTAINER_FREEZER_SPECIFIC_FACILITY:
                businessBaseService = containerFreezerSpecificFacilityService;
                break;
            case WATER_SUPPLY_CONSTRUCTION_AGENCY:
                businessBaseService = waterSupplyConstructionAgencyService;
                break;
            case DISINFECTION:
                businessBaseService = disinfectionService;
                break;
            case BIG_SCALE_STORE:
                businessBaseService = bigScaleStoreService;
                break;
            case OVERALL_SPORTS_FACILITY:
                businessBaseService = overallSportsFacilityService;
                break;
            case STANDARD_PLASTIC_GARBAGE_BAG_SALE:
                businessBaseService = standardPlasticGarbageBagSaleService;
                break;
            case WATER_STORAGE_TANK_CLEANING:
                businessBaseService = waterStorageTankCleaningService;
                break;
            case CONSTRUCTION_WASTE_TREATMENT:
                businessBaseService = constructionWasteTreatmentService;
                break;
            case CULTURE_ARTS_CORPORATION:
                businessBaseService = cultureArtsCorporationService;
                break;
            case MUSEUM_ART_GALLERY:
                businessBaseService = museumArtGalleryService;
                break;
            case TOBACCO_IMPORT_SALE:
                businessBaseService = tobaccoImportSaleService;
                break;
            case TOBACCO_WHOLESALE:
                businessBaseService = tobaccoWholesaleService;
                break;
            case TOBACCO_RETAIL:
                businessBaseService = tobaccoRetailService;
                break;
            case INTERNATIONAL_LOGISTICS_BROKERAGE:
                businessBaseService = internationalLogisticsBrokerageService;
                break;
            case WAREHOUSE:
                businessBaseService = warehouseService;
                break;
            case CIVIL_DEFENCE_SHELTER_FACILITY:
                businessBaseService = civilDefenceShelterFacilityService;
                break;
            case CIVIL_DEFENCE_WATER_SUPPLY_FACILITY:
                businessBaseService = civilDefenceWaterSupplyFacilityService;
                break;
            case ELEVATOR_MANUFACTURING_IMPORT:
                businessBaseService = elevatorManufacturingImportService;
                break;
            case ELEVATOR_MAINTENANCE:
                businessBaseService = elevatorMaintenanceService;
                break;
            case FUNERAL_DIRECTOR_EDUCATION_ORGANIZATION:
                businessBaseService = funeralDirectorEducationOrganizationService;
                break;
            case CAREGIVER_EDUCATION_ORGANIZATION:
                businessBaseService = caregiverEducationOrganizationService;
                break;
            case FEE_CHARGING_EMPLOYMENT_AGENCY:
                businessBaseService = feeChargingEmploymentAgencyService;
                break;
            case FREE_EMPLOYMENT_AGENCY:
                businessBaseService = freeEmploymentAgencyService;
                break;
            case ADMINISTRATIVE_AGENT:
                businessBaseService = administrativeAgentService;
                break;
            case DOOR_TO_DOOR_SALE:
                businessBaseService = doorToDoorSaleService;
                break;
            case COLD_CALLING_SALE:
                businessBaseService = coldCallingSaleService;
                break;
            case TELEMARKETING:
                businessBaseService = telemarketingService;
                break;
            case MULTILEVEL_SALE:
                businessBaseService = multilevelSaleService;
                break;
            case SPONSORED_DOOR_TO_DOOR_SALE:
                businessBaseService = sponsoredDoorToDoorSaleService;
                break;
            case LOCAL_CULTURE_CENTER:
                businessBaseService = localCultureCenterService;
                break;
            case OUTDOOR_ADVERTISING:
                businessBaseService = outdoorAdvertisingService;
                break;
            case PETROLEUM_SALE:
                businessBaseService = petroleumSaleService;
                break;
            case PETROLEUM_ALTERNATIVE_FUEL_SALE:
                businessBaseService = petroleumAlternativeFuelSaleService;
                break;
            default:
                throw new NoSuchObjectException("Business Category - NoSuchObjectException");
        }

        return businessBaseService;
    }
}

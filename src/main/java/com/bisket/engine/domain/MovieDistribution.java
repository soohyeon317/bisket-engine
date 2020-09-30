package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("movie_distribution")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDistribution extends Business {
    private String cultureSportsBusinessCategoryName;
    private String cultureBusinessPersonClassificationName;
    private String buildingFloorCount;
    private String environmentName;
    @Column(columnDefinition = "TEXT")
    private String productionHandlingItemContent;
    private String facilityArea;
    private String groundFloorCount;
    private String basementFloorCount;
    private String buildingUseName;
    private String passageBreadth;
    private String lightingFacilityIlluminance;
    private String singingRoomCount;
    private String teenagerRoomCount;
    private String emergencyStairsFlag;
    private String emergencyExitFlag;
    private String autoVentilationFlag;
    private String teenagerRoomFlag;
    private String specialLightingFlag;
    private String soundIsolationFacilityFlag;
    private String vcrName;
    private String lightingFacilityFlag;
    private String soundFacilityFlag;
    private String convenienceFacilityFlag;
    private String fireProtectionFacilityFlag;
    private String gameDeviceCount;
    private String otherBusinessCategoryName;
    private String provisionGameName;
    private String stageFormClassificationName;
    private String itemName;
    private String firstRegistrationTime;
    private String regionClassificationName;

    public void getAndSetIdentification(MovieDistribution other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(MovieDistribution other) {
        // 개방서비스명
        this.setOpenServiceName(other.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(other.getLicensingDate());
        // 인허가취소일자
        this.setLicensingCancelDate(other.getLicensingCancelDate());
        // 영업상태코드
        this.setBusinessStatusCode(other.getBusinessStatusCode());
        // 영업상태명
        this.setBusinessConditionsClassificationName(other.getBusinessConditionsClassificationName());
        // 상세영업상태코드
        this.setDetailedBusinessStatusCode(other.getDetailedBusinessStatusCode());
        // 상세영업상태명
        this.setDetailedBusinessStatusName(other.getDetailedBusinessStatusName());
        // 폐업일자
        this.setCloseDate(other.getCloseDate());
        // 휴업시작일자
        this.setIdleStartDate(other.getIdleStartDate());
        // 휴업종료일자
        this.setIdleEndDate(other.getIdleEndDate());
        // 재개업일자
        this.setReopenDate(other.getReopenDate());
        // 소재지전화번호
        this.setSitePhoneNumber(other.getSitePhoneNumber());
        // 소재지면적
        this.setSiteArea(other.getSiteArea());
        // 소재지우편번호
        this.setSitePostCode(other.getSitePostCode());
        // 소재지전체주소
        this.setSiteFullAddress(other.getSiteFullAddress());
        // 도로명우편번호
        this.setRoadNamePostCode(other.getRoadNamePostCode());
        // 도로명전체주소
        this.setRoadNameFullAddress(other.getRoadNameFullAddress());
        // 사업장명
        this.setBusinessPlaceName(other.getBusinessPlaceName());
        // 최종수정시점
        this.setLastModificationTime(other.getLastModificationTime());
        // 데이터갱신구분
        this.setDataUpdateClassification(other.getDataUpdateClassification());
        // 데이터갱신일자
        this.setDataUpdateDate(other.getDataUpdateDate());
        // 업태구분명
        this.setBusinessConditionsClassificationName(other.getBusinessConditionsClassificationName());
        // 좌표정보(X)
        this.setXCoordinate(other.getXCoordinate());
        // 좌표정보(Y)
        this.setYCoordinate(other.getYCoordinate());
        // 문화체육업종명
        this.setCultureSportsBusinessCategoryName(other.getCultureSportsBusinessCategoryName());
        // 문화사업자구분명
        this.setCultureBusinessPersonClassificationName(other.getCultureBusinessPersonClassificationName());
        // 총층수
        this.setBuildingFloorCount(other.getBuildingFloorCount());
        // 주변환경명
        this.setEnvironmentName(other.getEnvironmentName());
        // 제작취급품목내용
        this.setProductionHandlingItemContent(other.getProductionHandlingItemContent());
        // 시설면적
        this.setFacilityArea(other.getFacilityArea());
        // 지상층수
        this.setGroundFloorCount(other.getGroundFloorCount());
        // 지하층수
        this.setBasementFloorCount(other.getBasementFloorCount());
        // 건물용도명
        this.setBuildingUseName(other.getBuildingUseName());
        // 통로너비
        this.setPassageBreadth(other.getPassageBreadth());
        // 조명시설조도
        this.setLightingFacilityIlluminance(other.getLightingFacilityIlluminance());
        // 노래방실수
        this.setSingingRoomCount(other.getSingingRoomCount());
        // 청소년실수
        this.setTeenagerRoomCount(other.getTeenagerRoomCount());
        // 비상계단여부
        this.setEmergencyStairsFlag(other.getEmergencyStairsFlag());
        // 비상구여부
        this.setEmergencyExitFlag(other.getEmergencyExitFlag());
        // 자동환기여부
        this.setAutoVentilationFlag(other.getAutoVentilationFlag());
        // 청소년실여부
        this.setTeenagerRoomFlag(other.getTeenagerRoomFlag());
        // 특수조명여부
        this.setSpecialLightingFlag(other.getSpecialLightingFlag());
        // 방음시설여부
        this.setSoundFacilityFlag(other.getSoundFacilityFlag());
        // 비디오재생기명
        this.setVcrName(other.getVcrName());
        // 조명시설유무
        this.setLightingFacilityFlag(other.getLightingFacilityFlag());
        // 음향시설여부
        this.setSoundFacilityFlag(other.getSoundFacilityFlag());
        // 편의시설여부
        this.setConvenienceFacilityFlag(other.getConvenienceFacilityFlag());
        // 소방시설여부
        this.setFireProtectionFacilityFlag(other.getFireProtectionFacilityFlag());
        // 총게임기수
        this.setGameDeviceCount(other.getGameDeviceCount());
        // 기존게임업외업종명
        this.setOtherBusinessCategoryName(other.getOtherBusinessCategoryName());
        // 제공게임물명
        this.setProvisionGameName(other.getProvisionGameName());
        // 공연장형태구분명
        this.setStageFormClassificationName(other.getStageFormClassificationName());
        // 품목명
        this.setItemName(other.getItemName());
        // 최초등록시점
        this.setFirstRegistrationTime(other.getFirstRegistrationTime());
        // 지역구분명
        this.setRegionClassificationName(other.getRegionClassificationName());
    }
}

package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("domestic_travel")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomesticTravel extends Business {
    private String cultureSportsBusinessLineName;
    private String culturalBusinessOperatorClassificationName;
    private String regionClassificationName;
    private String buildingFloorCount;
    private String environmentName;
    @Column(columnDefinition = "TEXT")
    private String productionHandlingItemContent;
    private String insuranceOrganizationName;
    private String buildingUseName;
    private String groundFloorCount;
    private String basementFloorCount;
    private String guestRoomCount;
    private String annualBuildingArea;
    private String businessEnglishName;
    @Column(columnDefinition = "TEXT")
    private String businessEnglishAddress;
    private String shipTonnage;
    private String shipCount;
    @Column(columnDefinition = "TEXT")
    private String shipInformation;
    private String stageArea;
    private String seatingCapacity;
    private String souvenirKind;
    private String meetingRoomSeatingCapacity;
    private String facilityArea;
    @Column(columnDefinition = "TEXT")
    private String rideCountDetails;
    private String amusementFacilityCount;
    private String broadcastingFacilityFlag;
    private String powerProductionFacilityFlag;
    private String medicalOfficeFlag;
    private String informationDeskFlag;
    private String plannedTravelInsuranceStartDate;
    private String plannedTravelInsuranceEndDate;
    private String capital;
    private String insuranceStartDate;
    private String insuranceEndDate;
    @Column(columnDefinition = "TEXT")
    private String additionalFacilityDetails;
    private String facilityScale;

    public void getAndSetIdentification(DomesticTravel other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(DomesticTravel other) {
        // 개방서비스명
        this.setOpenServiceName(other.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(other.getLicensingDate());
        // 인허가취소일자
        this.setLicensingCancelDate(other.getLicensingCancelDate());
        // 영업상태코드
        this.setBusinessStatusCode(other.getBusinessStatusCode());
        // 영업상태명
        this.setBusinessStatusName(other.getBusinessStatusName());
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
        this.setBusinessTypeClassificationName(other.getBusinessTypeClassificationName());
        // 좌표정보(X)
        this.setXCoordinate(other.getXCoordinate());
        // 좌표정보(Y)
        this.setYCoordinate(other.getYCoordinate());
        // 문화체육업종명
        this.setCultureSportsBusinessLineName(other.getCultureSportsBusinessLineName());
        // 문화사업자구분명
        this.setCulturalBusinessOperatorClassificationName(other.getCulturalBusinessOperatorClassificationName());
        // 지역구분명
        this.setRegionClassificationName(other.getRegionClassificationName());
        // 총층수
        this.setBuildingFloorCount(other.getBuildingFloorCount());
        // 주변환경명
        this.setEnvironmentName(other.getEnvironmentName());
        // 제작취급품목내용
        this.setProductionHandlingItemContent(other.getProductionHandlingItemContent());
        // 보험기관명
        this.setInsuranceOrganizationName(other.getInsuranceOrganizationName());
        // 건물용도명
        this.setBuildingUseName(other.getBuildingUseName());
        // 지상층수
        this.setGroundFloorCount(other.getGroundFloorCount());
        // 지하층수
        this.setBasementFloorCount(other.getBasementFloorCount());
        // 객실수
        this.setGuestRoomCount(other.getGuestRoomCount());
        // 건축연면적
        this.setAnnualBuildingArea(other.getAnnualBuildingArea());
        // 영문상호명
        this.setBusinessEnglishName(other.getBusinessEnglishName());
        // 영문상호주소
        this.setBusinessEnglishAddress(other.getBusinessEnglishAddress());
        // 선박총톤수
        this.setShipTonnage(other.getShipTonnage());
        // 선박척수
        this.setShipCount(other.getShipCount());
        // 선박제원
        this.setShipInformation(other.getShipInformation());
        // 무대면적
        this.setStageArea(other.getStageArea());
        // 좌석수
        this.setSeatingCapacity(other.getSeatingCapacity());
        // 기념품종류
        this.setSouvenirKind(other.getSouvenirKind());
        // 회의실별동시수용인원
        this.setMeetingRoomSeatingCapacity(other.getMeetingRoomSeatingCapacity());
        // 시설면적
        this.setFacilityArea(other.getFacilityArea());
        // 놀이기구수내역
        this.setRideCountDetails(other.getRideCountDetails());
        // 놀이시설수
        this.setAmusementFacilityCount(other.getAmusementFacilityCount());
        // 방송시설유무
        this.setBroadcastingFacilityFlag(other.getBroadcastingFacilityFlag());
        // 발전시설유무
        this.setPowerProductionFacilityFlag(other.getPowerProductionFacilityFlag());
        // 의무실유무
        this.setMedicalOfficeFlag(other.getMedicalOfficeFlag());
        // 안내소유무
        this.setInformationDeskFlag(other.getInformationDeskFlag());
        // 기획여행보험시작일자
        this.setPlannedTravelInsuranceStartDate(other.getPlannedTravelInsuranceStartDate());
        // 기획여행보험종료일자
        this.setPlannedTravelInsuranceEndDate(other.getPlannedTravelInsuranceEndDate());
        // 자본금
        this.setCapital(other.getCapital());
        // 보험시작일자
        this.setInsuranceStartDate(other.getInsuranceStartDate());
        // 보험종료일자
        this.setInsuranceEndDate(other.getInsuranceEndDate());
        // 부대시설내역
        this.setAdditionalFacilityDetails(other.getAdditionalFacilityDetails());
        // 시설규모
        this.setFacilityScale(other.getFacilityScale());
    }
}

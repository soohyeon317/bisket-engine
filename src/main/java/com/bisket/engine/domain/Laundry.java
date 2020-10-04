package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("laundry")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laundry extends Business {
    private String sanitationBusinessTypeName;
    private String groundFloorCount;
    private String basementFloorCount;
    private String useStartGroundFloor;
    private String useEndGroundFloor;
    private String useStartBasementFloor;
    private String useEndBasementFloor;
    private String koreanStyleRoomCount;
    private String westernStyleRoomCount;
    private String bathRoomCount;
    private String sweatingRoomFlag;
    private String seatingCapacity;
    @Column(columnDefinition = "TEXT")
    private String conditionalApprovalRegistrationReason;
    private String conditionalApprovalStartDate;
    private String conditionalApprovalEndDate;
    private String buildingPossessionClassificationName;
    private String washingMachineCount;
    private String femaleWorkerCount;
    private String maleWorkerCount;
    private String recoveringDryerCount;
    private String bedCount;
    private String publiclyUsedBusinessPlaceFlag;

    public void getAndSetIdentification(Laundry other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(Laundry other) {
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
        // 위생업태명
        this.setSanitationBusinessTypeName(other.getSanitationBusinessTypeName());
        // 건물지상층수
        this.setGroundFloorCount(other.getGroundFloorCount());
        // 건물지하층수
        this.setBasementFloorCount(other.getBasementFloorCount());
        // 사용시작지상층
        this.setUseStartGroundFloor(other.getUseStartGroundFloor());
        // 사용끝지상층
        this.setUseEndGroundFloor(other.getUseEndGroundFloor());
        // 사용시작지하층
        this.setUseStartBasementFloor(other.getUseStartBasementFloor());
        // 사용끝지하층
        this.setUseEndBasementFloor(other.getUseEndBasementFloor());
        // 한실수
        this.setKoreanStyleRoomCount(other.getKoreanStyleRoomCount());
        // 양실수
        this.setWesternStyleRoomCount(other.getWesternStyleRoomCount());
        // 욕실수
        this.setBathRoomCount(other.getBathRoomCount());
        // 발한실여부
        this.setSweatingRoomFlag(other.getSweatingRoomFlag());
        // 좌석수
        this.setSeatingCapacity(other.getSeatingCapacity());
        // 조건부허가신고사유
        this.setConditionalApprovalRegistrationReason(other.getConditionalApprovalRegistrationReason());
        // 조건부허가시작일자
        this.setConditionalApprovalStartDate(other.getConditionalApprovalStartDate());
        // 조건부허가종료일자
        this.setConditionalApprovalEndDate(other.getConditionalApprovalEndDate());
        // 건물소유구분명
        this.setBuildingPossessionClassificationName(other.getBuildingPossessionClassificationName());
        // 세탁기수
        this.setWashingMachineCount(other.getWashingMachineCount());
        // 여성종사자수
        this.setFemaleWorkerCount(other.getFemaleWorkerCount());
        // 남성종사자수
        this.setMaleWorkerCount(other.getMaleWorkerCount());
        // 회수건조수
        this.setRecoveringDryerCount(other.getRecoveringDryerCount());
        // 침대수
        this.setBedCount(other.getBedCount());
        // 다중이용업소여부
        this.setPubliclyUsedBusinessPlaceFlag(other.getPubliclyUsedBusinessPlaceFlag());
    }
}

package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("postpartum_care")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostpartumCare extends Business {
    private String pregnantWomanCapacity;
    private String babyCapacity;
    private String pregnantWomanRoomArea;
    private String babyRoomArea;
    private String nursingRoomArea;
    private String foodServiceFacilityArea;
    private String laundryRoomArea;
    private String bathRoomArea;
    private String careCenterRestRoomArea;
    private String officeArea;
    private String nurseCount;
    private String nurseAidCount;
    private String nutritionistCount;
    private String cookingPersonnelCount;
    private String cleaningPersonnelCount;
    private String otherStaffCount;
    private String buildingFloorCount;
    private String groundFloorCount;
    private String basementFloorCount;

    public void getAndSetIdentification(PostpartumCare other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(PostpartumCare other) {
        // 개방서비스명
        this.setOpenServiceName(other.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(other.getLicensingDate());
        // 인허가취소일자
        this.setLicensingCancelDate(other.getLicensingCancelDate());
        // 영업상태코드
        this.setBusinessStatusCode(other.getBusinessStatusCode());
        // 영업상태명
        this.setBusinessCategoryClassificationName(other.getBusinessCategoryClassificationName());
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
        this.setBusinessCategoryClassificationName(other.getBusinessCategoryClassificationName());
        // 좌표정보(X)
        this.setXCoordinate(other.getXCoordinate());
        // 좌표정보(Y)
        this.setYCoordinate(other.getYCoordinate());
        // 임산부정원수
        this.setPregnantWomanCapacity(other.getPregnantWomanCapacity());
        // 영유아정원수
        this.setBabyCapacity(other.getBabyCapacity());
        // 임산부실면적
        this.setPregnantWomanRoomArea(other.getPregnantWomanRoomArea());
        // 영유아실면적
        this.setBabyRoomArea(other.getBabyRoomArea());
        // 모유수유실면적
        this.setNursingRoomArea(other.getNursingRoomArea());
        // 급식시설면적
        this.setFoodServiceFacilityArea(other.getFoodServiceFacilityArea());
        // 세탁실면적
        this.setLaundryRoomArea(other.getLaundryRoomArea());
        // 목욕실면적
        this.setBabyRoomArea(other.getBabyRoomArea());
        // 조리원화장실면적
        this.setCareCenterRestRoomArea(other.getCareCenterRestRoomArea());
        // 사무실면적
        this.setOfficeArea(other.getOfficeArea());
        // 간호사수
        this.setNurseCount(other.getNurseCount());
        // 간호조무사수
        this.setNurseAidCount(other.getNurseAidCount());
        // 영양사수
        this.setNutritionistCount(other.getNutritionistCount());
        // 취사부수
        this.setCookingPersonnelCount(other.getCookingPersonnelCount());
        // 미화원수
        this.setCleaningPersonnelCount(other.getCleaningPersonnelCount());
        // 기타인원수
        this.setOtherStaffCount(other.getOtherStaffCount());
        // 건물층수
        this.setBuildingFloorCount(other.getBuildingFloorCount());
        // 지상층수
        this.setGroundFloorCount(other.getGroundFloorCount());
        // 지하층수
        this.setBasementFloorCount(other.getBasementFloorCount());
    }
}

package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("container_wrapper_production")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerWrapperProduction extends Business {
    private String sanitationBusinessTypeName;
    private String maleWorkerCount;
    private String femaleWorkerCount;
    private String businessPlaceEnvironmentClassificationName;
    private String gradeClassificationName;
    private String waterSupplyFacilityClassificationName;
    private String employeeCount;
    private String headOfficeEmployeeCount;
    private String factoryOfficeEmployeeCount;
    private String factorySaleEmployeeCount;
    private String factoryProductionEmployeeCount;
    private String buildingPossessionClassificationName;
    private String deposit;
    private String monthlyRent;
    private String publiclyUsedBusinessPlaceFlag;
    private String facilityScale;
    private String traditionalBusinessPlaceAppointmentNumber;
    private String traditionalBusinessPlaceMainFood;
    private String homepage;

    public void getAndSetIdentification(ContainerWrapperProduction other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(ContainerWrapperProduction other) {
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
        // 남성종사자수
        this.setMaleWorkerCount(other.getMaleWorkerCount());
        // 여성종사자수
        this.setFemaleWorkerCount(other.getFemaleWorkerCount());
        // 영업장주변구분명
        this.setBusinessPlaceEnvironmentClassificationName(other.getBusinessPlaceEnvironmentClassificationName());
        // 등급구분명
        this.setGradeClassificationName(other.getGradeClassificationName());
        // 급수시설구분명
        this.setWaterSupplyFacilityClassificationName(other.getWaterSupplyFacilityClassificationName());
        // 총종업원수
        this.setEmployeeCount(other.getEmployeeCount());
        // 본사종업원수
        this.setHeadOfficeEmployeeCount(other.getHeadOfficeEmployeeCount());
        // 공장사무직종업원수
        this.setFactoryOfficeEmployeeCount(other.getFactoryOfficeEmployeeCount());
        // 공장판매직종업원수
        this.setFactorySaleEmployeeCount(other.getFactorySaleEmployeeCount());
        // 공장생산직종업원수
        this.setFactoryProductionEmployeeCount(other.getFactoryProductionEmployeeCount());
        // 건물소유구분명
        this.setBuildingPossessionClassificationName(other.getBuildingPossessionClassificationName());
        // 보증액
        this.setDeposit(other.getDeposit());
        // 월세액
        this.setMonthlyRent(other.getMonthlyRent());
        // 다중이용업소여부
        this.setPubliclyUsedBusinessPlaceFlag(other.getPubliclyUsedBusinessPlaceFlag());
        // 시설총규모
        this.setFacilityScale(other.getFacilityScale());
        // 전통업소지정번호
        this.setTraditionalBusinessPlaceAppointmentNumber(other.getTraditionalBusinessPlaceAppointmentNumber());
        // 전통업소주된음식
        this.setTraditionalBusinessPlaceMainFood(other.getTraditionalBusinessPlaceMainFood());
        // 홈페이지
        this.setHomepage(other.getHomepage());
    }
}

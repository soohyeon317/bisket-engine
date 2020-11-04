package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HORSE_RIDING_COURSE")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorseRidingCourse extends Business {
    private String cultureSportsBusinessLineName;
    private String publicPrivateClassificationName;
    private String insuranceFlag;
    private String instructorCount;
    private String buildingDongCount;
    private String annualBuildingArea;
    private String memberRecruitmentCapacity;
    private String detailedBusinessLineName;
    private String corporationName;

    public void getAndSetIdentification(HorseRidingCourse other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(HorseRidingCourse other) {
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
        // 공사립구분명
        this.setPublicPrivateClassificationName(other.getPublicPrivateClassificationName());
        // 보험가입여부코드
        this.setInsuranceFlag(other.getInsuranceFlag());
        // 지도자수
        this.setInstructorCount(other.getInstructorCount());
        // 건축물동수
        this.setBuildingDongCount(other.getBuildingDongCount());
        // 건축물연면적
        this.setAnnualBuildingArea(other.getAnnualBuildingArea());
        // 회원모집총인원
        this.setMemberRecruitmentCapacity(other.getMemberRecruitmentCapacity());
        // 세부업종명
        this.setDetailedBusinessLineName(other.getDetailedBusinessLineName());
        // 법인명
        this.setCorporationName(other.getCorporationName());
    }
}

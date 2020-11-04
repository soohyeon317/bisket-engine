package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ELEVATOR_MANUFACTURING_IMPORT")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElevatorManufacturingImport extends Business {
    private String businessLineClassificationName;
    @Column(columnDefinition = "TEXT")
    private String managementBusinessClassificationName;
    private String capital;
    private String assets;
    private String maintenanceRange;
    private String maintenanceManCount;
    private String practicalTechnicianCount;
    private String designTechnicianCount;
    private String manufacturingTechnicianCount;
    private String officialCount;
    private String staffCount;
    private String technicalPostStaffCount;
    private String skillPostStaffCount;
    private String officeStaffCount;
    private String otherStaffCount;
    private String companyClassificationName;

    public void getAndSetIdentification(ElevatorManufacturingImport other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(ElevatorManufacturingImport other) {
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
        // 업종구분명
        this.setBusinessLineClassificationName(other.getBusinessLineClassificationName());
        // 관리업구분명
        this.setManagementBusinessClassificationName(other.getManagementBusinessClassificationName());
        // 자본금
        this.setCapital(other.getCapital());
        // 자산
        this.setCapital(other.getCapital());
        // 보수범위
        this.setMaintenanceRange(other.getMaintenanceRange());
        // 유지관리책임인력수
        this.setMaintenanceManCount(other.getMaintenanceManCount());
        // 실무기술인력수
        this.setPracticalTechnicianCount(other.getPracticalTechnicianCount());
        // 설계책임기술인력수
        this.setDesignTechnicianCount(other.getDesignTechnicianCount());
        // 제조책임기술인력수
        this.setManufacturingTechnicianCount(other.getManufacturingTechnicianCount());
        // 임원수
        this.setOfficialCount(other.getOfficialCount());
        // 총직원수
        this.setStaffCount(other.getStaffCount());
        // 기술직직원수
        this.setTechnicalPostStaffCount(other.getTechnicalPostStaffCount());
        // 기능직직원수
        this.setSkillPostStaffCount(other.getSkillPostStaffCount());
        // 사무직직원수
        this.setOfficeStaffCount(other.getOfficeStaffCount());
        // 기타직원수
        this.setOtherStaffCount(other.getOtherStaffCount());
        // 회사구분명
        this.setCompanyClassificationName(other.getCompanyClassificationName());
    }
}

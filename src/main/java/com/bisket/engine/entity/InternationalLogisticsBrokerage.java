package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("INTERNATIONAL_LOGISTICS_BROKERAGE")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternationalLogisticsBrokerage extends Business {
    private String autonomousBodyCode;
    private String businessTypeName;
    private String capital;
    private String appointedMaintenanceBusinessLineName;
    private String licenseDate;
    private String licenseValidityTermStartDate;
    private String licenseValidityTermEndDate;
    private String licenseIssuingOrganization;

    public void getAndSetIdentification(InternationalLogisticsBrokerage other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(InternationalLogisticsBrokerage other) {
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
        // 자치단체코드
        this.setAutonomousBodyCode(other.getAutonomousBodyCode());
        // 업체유형명
        this.setBusinessTypeName(other.getBusinessTypeName());
        // 자본금
        this.setCapital(other.getCapital());
        // 지정정비업종명
        this.setAppointedMaintenanceBusinessLineName(other.getAppointedMaintenanceBusinessLineName());
        // 면허일자
        this.setLicenseDate(other.getLicenseDate());
        // 면허유효기간시작일자
        this.setLicenseValidityTermStartDate(other.getLicenseValidityTermStartDate());
        // 면허유효기간종료일자
        this.setLicenseValidityTermEndDate(other.getLicenseValidityTermEndDate());
        // 자격면허발급기관
        this.setLicenseIssuingOrganization(other.getLicenseIssuingOrganization());
    }
}

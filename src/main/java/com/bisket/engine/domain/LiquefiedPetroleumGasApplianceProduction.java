package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("liquefied_petroleum_gas_appliance_production")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiquefiedPetroleumGasApplianceProduction extends Business {
    private String storageFacilityLocation;
    private String containerStoreroomArea;
    private String garageArea;
    private String officeArea;
    private String plumbingInstallationPlace;
    private String lengthChangeContent;
    private String handlingGasCapacity;
    private String gasApplianceKindName;
    private String facilityName;
    @Column(columnDefinition = "TEXT")
    private String itemStandard;
    private String exemptionRange;

    public void getAndSetIdentification(LiquefiedPetroleumGasApplianceProduction other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(LiquefiedPetroleumGasApplianceProduction other) {
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
        // 저장설비위치
        this.setStorageFacilityLocation(other.getStorageFacilityLocation());
        // 용기저장실면적
        this.setContainerStoreroomArea(other.getContainerStoreroomArea());
        // 차고지면적
        this.setGarageArea(other.getGarageArea());
        // 사무실면적
        this.setOfficeArea(other.getOfficeArea());
        // 배관설치장소
        this.setPlumbingInstallationPlace(other.getPlumbingInstallationPlace());
        // 길이변경내용
        this.setLengthChangeContent(other.getLengthChangeContent());
        // 취급가스용량
        this.setHandlingGasCapacity(other.getHandlingGasCapacity());
        // 가스용품종류명
        this.setGasApplianceKindName(other.getGasApplianceKindName());
        // 설비명
        this.setFacilityName(other.getFacilityName());
        // 물품규격
        this.setItemStandard(other.getItemStandard());
        // 면제범위
        this.setExemptionRange(other.getExemptionRange());
    }
}

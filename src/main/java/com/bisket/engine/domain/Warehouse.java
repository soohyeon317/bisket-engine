package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("warehouse")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse extends Business {
    private String generalWarehouseDongCount;
    private String generalWarehouseArea;
    private String refrigeratorFreezerDongCount;
    private String refrigeratorFreezerArea;
    private String storagePlaceArea;
    private String employeeCount;
    @Column(columnDefinition = "TEXT")
    private String facilityEquipmentStatus;
    private String storageRate;
    private String corporationFlagName;
    private String businessTypeStorageWarehouse;
    private String businessTypeTransportCourier;
    private String businessTypeSale;
    private String businessTypeProduction;

    public void getAndSetIdentification(Warehouse other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(Warehouse other) {
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
        // 일반창고_동수
        this.setGeneralWarehouseDongCount(other.getGeneralWarehouseDongCount());
        // 일반창고_면적
        this.setGeneralWarehouseArea(other.getGeneralWarehouseArea());
        // 냉동_냉장창고_동수
        this.setRefrigeratorFreezerDongCount(other.getRefrigeratorFreezerDongCount());
        // 냉동_냉장창고_면적
        this.setRefrigeratorFreezerArea(other.getRefrigeratorFreezerArea());
        // 보관장소_면적
        this.setStoragePlaceArea(other.getStoragePlaceArea());
        // 종업원수
        this.setEmployeeCount(other.getEmployeeCount());
        // 시설/장비현황
        this.setFacilityEquipmentStatus(other.getFacilityEquipmentStatus());
        // 보관요율
        this.setStorageRate(other.getStorageRate());
        // 법인여부명
        this.setCorporationFlagName(other.getCorporationFlagName());
        // 업태_보관및창고업
        this.setBusinessTypeStorageWarehouse(other.getBusinessTypeStorageWarehouse());
        // 업태_운송및택배업
        this.setBusinessTypeTransportCourier(other.getBusinessTypeTransportCourier());
        // 업태_판매업
        this.setBusinessTypeSale(other.getBusinessTypeSale());
        // 업태_제조업
        this.setBusinessTypeProduction(other.getBusinessTypeProduction());
    }
}

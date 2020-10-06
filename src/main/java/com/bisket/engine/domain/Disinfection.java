package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("disinfection")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disinfection extends Business {
    private String officeArea;
    private String disinfectionVehicleGarageArea;
    private String ultrafineParticleSpreaderCount;
    private String portableDisinfectorCount;
    private String powerSprayerCount;
    private String handSprayerCount;
    private String gasMaskCount;
    private String protectiveGlassesCount;
    private String protectiveClothingCount;
    private String vacuumCleanerCount;

    public void getAndSetIdentification(Disinfection other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(Disinfection other) {
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
        // 사무실면적
        this.setOfficeArea(other.getOfficeArea());
        // 소독차량차고면적
        this.setDisinfectionVehicleGarageArea(other.getDisinfectionVehicleGarageArea());
        // 초미립자살포기수
        this.setUltrafineParticleSpreaderCount(other.getUltrafineParticleSpreaderCount());
        // 휴대용소독기수
        this.setPortableDisinfectorCount(other.getPortableDisinfectorCount());
        // 동력분무기수
        this.setPowerSprayerCount(other.getPowerSprayerCount());
        // 수동식분무기수
        this.setHandSprayerCount(other.getHandSprayerCount());
        // 방독면수
        this.setGasMaskCount(other.getGasMaskCount());
        // 보호안경수
        this.setProtectiveGlassesCount(other.getProtectiveGlassesCount());
        // 보호용의복수
        this.setProtectiveClothingCount(other.getProtectiveClothingCount());
        // 진공청소기수
        this.setVacuumCleanerCount(other.getVacuumCleanerCount());
    }
}

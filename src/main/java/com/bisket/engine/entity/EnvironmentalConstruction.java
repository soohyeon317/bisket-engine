package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ENVIRONMENTAL_CONSTRUCTION")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentalConstruction extends Business {
    private String laboratoryArea;
    private String businessPlaceClassificationName;
    private String businessPlaceArea;
    private String consignmentBusinessName;
    private String laboratoryRegionCode;
    private String laboratoryPostCode;
    private String laboratoryAddressSan;
    private String laboratoryAddressBeonji;
    private String laboratoryAddressHo;
    private String laboratoryAddressTong;
    private String laboratoryAddressBan;
    @Column(columnDefinition = "TEXT")
    private String laboratorySpecialAddress;
    private String laboratorySpecialAddressDong;
    private String laboratorySpecialAddressHo;
    private String laboratoryRoadNameAddressSiGunGuCode;
    private String laboratoryRoadNameAddressEupMyeonDongCode;
    private String laboratoryRoadNameAddressEupMyeonDongClassification;
    private String laboratoryRoadNameAddressCode;
    @Column(columnDefinition = "TEXT")
    private String laboratoryRoadNameSpecialAddress;
    private String laboratoryRoadNameAddressBuildingFloorClassification;
    private String laboratoryRoadNameAddressBuildingOriginalNumber;
    private String laboratoryRoadNameAddressBuildingSubNumber;
    private String laboratoryRoadNameAddressPostCode;

    public void getAndSetIdentification(EnvironmentalConstruction other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(EnvironmentalConstruction other) {
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
        // 실험실면적
        this.setLaboratoryArea(other.getLaboratoryArea());
        // 사업장구분명
        this.setBusinessPlaceClassificationName(other.getBusinessPlaceClassificationName());
        // 영업소면적
        this.setBusinessPlaceArea(other.getBusinessPlaceArea());
        // 위탁업체명
        this.setConsignmentBusinessName(other.getConsignmentBusinessName());
        // 실험실지역코드
        this.setLaboratoryRegionCode(other.getLaboratoryRegionCode());
        // 실험실우편번호
        this.setLaboratoryPostCode(other.getLaboratoryPostCode());
        // 실험실산
        this.setLaboratoryAddressSan(other.getLaboratoryAddressSan());
        // 실험실번지
        this.setLaboratoryAddressBeonji(other.getLaboratoryAddressBeonji());
        // 실험실호
        this.setLaboratoryAddressHo(other.getLaboratoryAddressHo());
        // 실험실통
        this.setLaboratoryAddressTong(other.getLaboratoryAddressTong());
        // 실험실반
        this.setLaboratoryAddressBan(other.getLaboratoryAddressBan());
        // 실험실특수주소
        this.setLaboratorySpecialAddress(other.getLaboratorySpecialAddress());
        // 실험실특수주소동
        this.setLaboratorySpecialAddressDong(other.getLaboratorySpecialAddressDong());
        // 실험실특수주소호
        this.setLaboratorySpecialAddressHo(other.getLaboratorySpecialAddressHo());
        // 실험실도로명주소시군구코드
        this.setLaboratoryRoadNameAddressSiGunGuCode(other.getLaboratoryRoadNameAddressSiGunGuCode());
        // 실험실도로명주소읍면동코드
        this.setLaboratoryRoadNameAddressEupMyeonDongCode(other.getLaboratoryRoadNameAddressEupMyeonDongCode());
        // 실험실도로명주소읍면동구분
        this.setLaboratoryRoadNameAddressEupMyeonDongClassification(other.getLaboratoryRoadNameAddressEupMyeonDongClassification());
        // 실험실도로명주소코드
        this.setLaboratoryRoadNameAddressCode(other.getLaboratoryRoadNameAddressCode());
        // 실험실도로명특수주소
        this.setLaboratorySpecialAddress(other.getLaboratorySpecialAddress());
        // 실험실도로명주소건물층구분
        this.setLaboratoryRoadNameAddressBuildingFloorClassification(other.getLaboratoryRoadNameAddressBuildingFloorClassification());
        // 실험실도로명주소건물본번호
        this.setLaboratoryRoadNameAddressBuildingOriginalNumber(other.getLaboratoryRoadNameAddressBuildingOriginalNumber());
        // 실험실도로명주소건물부번호
        this.setLaboratoryRoadNameAddressBuildingSubNumber(other.getLaboratoryRoadNameAddressBuildingSubNumber());
        // 실험실도로명주소우편번호
        this.setLaboratoryRoadNameAddressPostCode(other.getLaboratoryRoadNameAddressPostCode());
    }
}

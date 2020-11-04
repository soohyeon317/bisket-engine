package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MUSEUM_ART_GALLERY")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseumArtGallery extends Business {
    private String cultureSportsBusinessLineName;
    private String completionDate;
    private String hallOpenDate;
    private String managementSubjectClassificationName;
    private String museumArtGalleryKindName;
    private String museumArtGalleryTypeName;
    private String hallCloseDate;
    @Column(columnDefinition = "TEXT")
    private String hallCloseReason;
    private String capital;
    private String capitalNeeds;
    @Column(columnDefinition = "TEXT")
    private String corporationEstablishmentPurpose;
    @Column(columnDefinition = "TEXT")
    private String approvalCondition;
    private String disincorporationDate;
    private String corporationName;

    public void getAndSetIdentification(MuseumArtGallery other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(MuseumArtGallery other) {
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
        // 준공일자
        this.setCompletionDate(other.getCompletionDate());
        // 개관일자
        this.setHallOpenDate(other.getHallOpenDate());
        // 운영주체구분명
        this.setManagementSubjectClassificationName(other.getManagementSubjectClassificationName());
        // 박물관미술관종류명
        this.setMuseumArtGalleryKindName(other.getMuseumArtGalleryKindName());
        // 박물관미술관유형명
        this.setMuseumArtGalleryTypeName(other.getMuseumArtGalleryTypeName());
        // 폐관일자
        this.setHallCloseDate(other.getHallCloseDate());
        // 폐관사유
        this.setHallCloseReason(other.getHallCloseReason());
        // 자본금
        this.setCapital(other.getCapital());
        // 소요자금
        this.setCapitalNeeds(other.getCapitalNeeds());
        // 법인설립목적
        this.setCorporationEstablishmentPurpose(other.getCorporationEstablishmentPurpose());
        // 허가조건
        this.setApprovalCondition(other.getApprovalCondition());
        // 법인해산일자
        this.setDisincorporationDate(other.getDisincorporationDate());
        // 법인명
        this.setCorporationName(other.getCorporationName());
    }
}

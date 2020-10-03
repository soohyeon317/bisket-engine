package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("similar_medical_treatment")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimilarMedicalTreatment extends Business {
    private String medicalOrganizationClassificationName;
    private String employeeCount;
    private String licenseHolderCount;
    private String assistantEmployeeCount;
    private String facilityManagerCount;
    private String otherEmployeeCount;
    private String sickbedCount;
    private String bathRoomArea;
    private String totalArea;

    public void getAndSetIdentification(SimilarMedicalTreatment other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(SimilarMedicalTreatment other) {
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
        // 의료기관종별명
        this.setMedicalOrganizationClassificationName(other.getMedicalOrganizationClassificationName());
        // 종업원수
        this.setEmployeeCount(other.getEmployeeCount());
        // 자격증소유자수
        this.setLicenseHolderCount(other.getLicenseHolderCount());
        // 보조종업원수
        this.setAssistantEmployeeCount(other.getAssistantEmployeeCount());
        // 시설관리자수
        this.setFacilityManagerCount(other.getFacilityManagerCount());
        // 기타종업원수
        this.setOtherEmployeeCount(other.getOtherEmployeeCount());
        // 병상수
        this.setSickbedCount(other.getSickbedCount());
        // 욕실면적
        this.setBathRoomArea(other.getBathRoomArea());
        // 총면적
        this.setTotalArea(other.getTotalArea());
    }
}

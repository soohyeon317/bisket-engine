package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMERGENCY_PATIENT_TRANSFER")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyPatientTransfer extends Business {
    private String medicalOrganizationClassificationName;
    private String medicalPersonnelCount;
    private String hospitalRoomCount;
    private String sickbedCount;
    private String totalArea;
    @Column(columnDefinition = "TEXT")
    private String treatmentSubjectContent;
    @Column(columnDefinition = "TEXT")
    private String treatmentSubjectContentName;
    private String appointmentCancelDate;
    private String palliativeMedicineAppointmentType;
    private String palliativeMedicineDepartmentName;
    private String specialAmbulanceCount;
    private String generalAmbulanceCount;
    private String employeeCount;
    private String paramedicCount;
    private String approvedSickbedCount;
    private String firstAppointmentDate;

    public void getAndSetIdentification(EmergencyPatientTransfer other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }

    public void update(EmergencyPatientTransfer other) {
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
        // 의료인수
        this.setMedicalPersonnelCount(other.getMedicalPersonnelCount());
        // 입원실수
        this.setHospitalRoomCount(other.getHospitalRoomCount());
        // 병상수
        this.setSickbedCount(other.getSickbedCount());
        // 총면적
        this.setTotalArea(other.getTotalArea());
        // 진료과목내용
        this.setTreatmentSubjectContent(other.getTreatmentSubjectContent());
        // 진료과목내용명
        this.setTreatmentSubjectContentName(other.getTreatmentSubjectContentName());
        // 지정취소일자
        this.setAppointmentCancelDate(other.getAppointmentCancelDate());
        // 완화의료지정형태
        this.setPalliativeMedicineAppointmentType(other.getPalliativeMedicineAppointmentType());
        // 완화의료담당부서명
        this.setPalliativeMedicineDepartmentName(other.getPalliativeMedicineDepartmentName());
        // 구급차특수
        this.setSpecialAmbulanceCount(other.getSpecialAmbulanceCount());
        // 구급차일반
        this.setGeneralAmbulanceCount(other.getGeneralAmbulanceCount());
        // 총인원
        this.setEmployeeCount(other.getEmployeeCount());
        // 구조사수
        this.setParamedicCount(other.getParamedicCount());
        // 허가병상수
        this.setApprovedSickbedCount(other.getApprovedSickbedCount());
        // 최초지정일자
        this.setFirstAppointmentDate(other.getFirstAppointmentDate());
    }
}

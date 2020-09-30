package com.bisket.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dental_lab")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentalLab extends Business {
    private String laboratoryLatheCount;
    private String centrifugalCastingMachineCount;
    private String laboratoryMotorCount;
    private String acetyleneCount;
    private String dentalPressCount;
    private String electricFurnaceCount;
    private String porcelainFurnaceCount;
    private String ultrasonicCleanerCount;
    private String surveyorCount;
    private String vibratorCount;
    private String trimmerCount;
    private String laboratoryCompressorCount;
    private String sanderCount;
    private String vacuumMixerCount;
    private String pindexCount;

    public void getAndSetIdentification(DentalLab other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(DentalLab other) {
        // 개방서비스ID
        this.setOpenServiceId(other.getOpenServiceId());
        // 개방자치단체코드
        this.setOpenAutonomousEntityCode(other.getOpenAutonomousEntityCode());
        // 개방서비스명
        this.setOpenServiceName(other.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(other.getLicensingDate());
        // 인허가취소일자
        this.setLicensingCancelDate(other.getLicensingCancelDate());
        // 영업상태코드
        this.setBusinessStatusCode(other.getBusinessStatusCode());
        // 영업상태명
        this.setBusinessConditionsClassificationName(other.getBusinessConditionsClassificationName());
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
        this.setBusinessConditionsClassificationName(other.getBusinessConditionsClassificationName());
        // 좌표정보(X)
        this.setXCoordinate(other.getXCoordinate());
        // 좌표정보(Y)
        this.setYCoordinate(other.getYCoordinate());
        // 기공용레스수
        this.setLaboratoryLatheCount(other.getLaboratoryLatheCount());
        // 원심주조기수
        this.setCentrifugalCastingMachineCount(other.getCentrifugalCastingMachineCount());
        // 기공용모터수
        this.setLaboratoryMotorCount(other.getLaboratoryMotorCount());
        // 아세틸렌수
        this.setAcetyleneCount(other.getAcetyleneCount());
        // 치과용프레스수
        this.setDentalPressCount(other.getDentalPressCount());
        // 전기로수
        this.setElectricFurnaceCount(other.getElectricFurnaceCount());
        // 포셀린로수
        this.setPorcelainFurnaceCount(other.getPorcelainFurnaceCount());
        // 초음파청소기수
        this.setUltrasonicCleanerCount(other.getUltrasonicCleanerCount());
        // 서베이어수
        this.setSurveyorCount(other.getSurveyorCount());
        // 진동기수
        this.setVibratorCount(other.getVibratorCount());
        // 트리머수
        this.setTrimmerCount(other.getTrimmerCount());
        // 기공용컴프레서수
        this.setLaboratoryCompressorCount(other.getLaboratoryCompressorCount());
        // 샌드기수
        this.setSanderCount(other.getSanderCount());
        // 진공매몰기수
        this.setVacuumMixerCount(other.getVacuumMixerCount());
        // 핀덱스수
        this.setPindexCount(other.getPindexCount());
    }
}

package com.bisket.engine.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("safety_officinal_sale")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyOfficinalSale extends Business {
    private String storeBusinessArea;

    public void getAndSetIdentification(SafetyOfficinalSale other) {
        this.setId(other.getId());
        this.setCreatedAt(other.getCreatedAt());
        this.setModifiedAt(other.getModifiedAt());
    }
    
    public void update(SafetyOfficinalSale safetyOfficinalSale) {
        // 개방서비스ID
        this.setOpenServiceId(safetyOfficinalSale.getOpenServiceId());
        // 개방자치단체코드
        this.setOpenAutonomousEntityCode(safetyOfficinalSale.getOpenAutonomousEntityCode());
        // 개방서비스명
        this.setOpenServiceName(safetyOfficinalSale.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(safetyOfficinalSale.getOpenServiceName());
        // 인허가취소일자
        this.setLicensingCancelDate(safetyOfficinalSale.getOpenServiceName());
        // 영업상태코드
        this.setBusinessStatusCode(safetyOfficinalSale.getOpenServiceName());
        // 영업상태명
        this.setBusinessConditionsClassificationName(safetyOfficinalSale.getOpenServiceName());
        // 상세영업상태코드
        this.setDetailedBusinessStatusCode(safetyOfficinalSale.getOpenServiceName());
        // 상세영업상태명
        this.setDetailedBusinessStatusName(safetyOfficinalSale.getOpenServiceName());
        // 폐업일자
        this.setCloseDate(safetyOfficinalSale.getOpenServiceName());
        // 휴업시작일자
        this.setIdleStartDate(safetyOfficinalSale.getOpenServiceName());
        // 휴업종료일자
        this.setIdleEndDate(safetyOfficinalSale.getOpenServiceName());
        // 재개업일자
        this.setReopenDate(safetyOfficinalSale.getOpenServiceName());
        // 소재지전화번호
        this.setSitePhoneNumber(safetyOfficinalSale.getOpenServiceName());
        // 소재지면적
        this.setSiteArea(safetyOfficinalSale.getOpenServiceName());
        // 소재지우편번호
        this.setSitePostCode(safetyOfficinalSale.getOpenServiceName());
        // 소재지전체주소
        this.setSiteFullAddress(safetyOfficinalSale.getOpenServiceName());
        // 도로명우편번호
        this.setRoadNamePostCode(safetyOfficinalSale.getOpenServiceName());
        // 도로명전체주소
        this.setRoadNameFullAddress(safetyOfficinalSale.getOpenServiceName());
        // 사업장명
        this.setBusinessPlaceName(safetyOfficinalSale.getOpenServiceName());
        // 최종수정시점
        this.setLastModificationTime(safetyOfficinalSale.getOpenServiceName());
        // 데이터갱신구분
        this.setDataUpdateClassification(safetyOfficinalSale.getOpenServiceName());
        // 데이터갱신일자
        this.setDataUpdateDate(safetyOfficinalSale.getOpenServiceName());
        // 업태구분명
        this.setBusinessConditionsClassificationName(safetyOfficinalSale.getOpenServiceName());
        // 좌표정보(X)
        this.setXCoordinate(safetyOfficinalSale.getOpenServiceName());
        // 좌표정보(Y)
        this.setYCoordinate(safetyOfficinalSale.getOpenServiceName());
        // 판매점영업면적
        this.setStoreBusinessArea(safetyOfficinalSale.getStoreBusinessArea());
    }
}

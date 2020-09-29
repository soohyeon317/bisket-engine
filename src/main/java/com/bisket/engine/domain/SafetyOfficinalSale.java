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
    
    public void update(SafetyOfficinalSale other) {
        // 개방서비스ID
        this.setOpenServiceId(other.getOpenServiceId());
        // 개방자치단체코드
        this.setOpenAutonomousEntityCode(other.getOpenAutonomousEntityCode());
        // 개방서비스명
        this.setOpenServiceName(other.getOpenServiceName());
        // 인허가일자
        this.setLicensingDate(other.getOpenServiceName());
        // 인허가취소일자
        this.setLicensingCancelDate(other.getOpenServiceName());
        // 영업상태코드
        this.setBusinessStatusCode(other.getOpenServiceName());
        // 영업상태명
        this.setBusinessConditionsClassificationName(other.getOpenServiceName());
        // 상세영업상태코드
        this.setDetailedBusinessStatusCode(other.getOpenServiceName());
        // 상세영업상태명
        this.setDetailedBusinessStatusName(other.getOpenServiceName());
        // 폐업일자
        this.setCloseDate(other.getOpenServiceName());
        // 휴업시작일자
        this.setIdleStartDate(other.getOpenServiceName());
        // 휴업종료일자
        this.setIdleEndDate(other.getOpenServiceName());
        // 재개업일자
        this.setReopenDate(other.getOpenServiceName());
        // 소재지전화번호
        this.setSitePhoneNumber(other.getOpenServiceName());
        // 소재지면적
        this.setSiteArea(other.getOpenServiceName());
        // 소재지우편번호
        this.setSitePostCode(other.getOpenServiceName());
        // 소재지전체주소
        this.setSiteFullAddress(other.getOpenServiceName());
        // 도로명우편번호
        this.setRoadNamePostCode(other.getOpenServiceName());
        // 도로명전체주소
        this.setRoadNameFullAddress(other.getOpenServiceName());
        // 사업장명
        this.setBusinessPlaceName(other.getOpenServiceName());
        // 최종수정시점
        this.setLastModificationTime(other.getOpenServiceName());
        // 데이터갱신구분
        this.setDataUpdateClassification(other.getOpenServiceName());
        // 데이터갱신일자
        this.setDataUpdateDate(other.getOpenServiceName());
        // 업태구분명
        this.setBusinessConditionsClassificationName(other.getOpenServiceName());
        // 좌표정보(X)
        this.setXCoordinate(other.getOpenServiceName());
        // 좌표정보(Y)
        this.setYCoordinate(other.getOpenServiceName());
        // 판매점영업면적
        this.setStoreBusinessArea(other.getStoreBusinessArea());
    }
}

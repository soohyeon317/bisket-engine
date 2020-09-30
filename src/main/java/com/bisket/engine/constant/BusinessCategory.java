package com.bisket.engine.constant;

public enum BusinessCategory {
    HOSPITAL("병원"),
    CLINIC("의원"),
    SAFETY_OFFICINAL_SALE("안전상비의약품판매업소"),
    EMERGENCY_PATIENT_TRANSFER("응급환자이송업"),
    MEDICAL_CORPORATION("의료법인"),
    POSTPARTUM_CARE("산후조리업"),
    PHARMACY("약국"),
    SIMILAR_MEDICAL_TREATMENT("의료유사업"),
    GLASSES("안경업"),
    MEDICAL_ORGANIZATION_LAUNDRY_PROCESSING("의료기관세탁물처리업"),
    MEDICAL_DEVICE_SALE_LEASE("의료기기판매임대업"),
    MEDICAL_DEVICE_REPAIR("의료기기수리업"),
    DENTAL_LAB("치과기공소");

    private final String code;

    BusinessCategory(String code) {
        this.code = code;
    }

    private String getCode() {
        return this.code;
    }

    public static BusinessCategory getByCode(String code) {
        for (BusinessCategory businessCategory : BusinessCategory.values()) {
            if (businessCategory.getCode().equals(code)) {
                return businessCategory;
            }
        }
        return null;
    }
}

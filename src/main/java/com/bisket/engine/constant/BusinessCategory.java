package com.bisket.engine.constant;

public enum BusinessCategory {
    HOSPITAL("병원"),
    CLINIC("의원"),
    SAFETY_OFFICINAL_SALE("안전상비의약품판매업소"),
    EMERGENCY_PATIENT_TRANSFER("응급환자이송업"),
    MEDICAL_CORPORATION("의료법인");

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

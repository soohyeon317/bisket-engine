package com.bisket.engine.constant;

public enum BusinessCategory {
    SAFETY_OFFICINAL_SALE("안전상비의약품판매업소");

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

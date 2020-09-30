package com.bisket.engine.common;

public enum BusinessCategory {
    HOSPITAL("병원"),
    CLINIC("의원"),
    MEDICAL_CORPORATION("의료법인"),
    EMERGENCY_PATIENT_TRANSFER("응급환자이송업"),
    AFFILIATED_MEDICAL_ORGANIZATION("부속의료기관"),
    SAFETY_OFFICINAL_SALE("안전상비의약품판매업소"),
    POSTPARTUM_CARE("산후조리업"),
    PHARMACY("약국"),
    SIMILAR_MEDICAL_TREATMENT("의료유사업"),
    GLASSES("안경업"),
    MEDICAL_ORGANIZATION_LAUNDRY_PROCESSING("의료기관세탁물처리업"),
    MEDICAL_DEVICE_SALE_LEASE("의료기기판매임대업"),
    MEDICAL_DEVICE_REPAIR("의료기기수리업"),
    DENTAL_LABORATORY("치과기공소"),
    ANIMAL_HOSPITAL("동물병원"),
    ANIMAL_PHARMACY("동물약국"),
    SLAUGHTER("도축업"),
    INCUBATION("부화업"),
    ANIMAL_MEDICAL_EQUIPMENT_SALE("동물용의료용구판매업"),
    FEED_PRODUCTION("사료제조업"),
    LIVESTOCK_ARTIFICIAL_INSEMINATION_CENTER("가축인공수정소"),
    ANIMAL_FUNERAL("동물장묘업"),
    ANIMAL_SALE("동물판매업"),
    LIVESTOCK_BREEDING("종축업"),
    MILK_COLLECTION("집유업"),
    LIVESTOCK_PRODUCT_TRANSPORT("축산물운반업"),
    LIVESTOCK_PRODUCT_STORAGE("축산물보관업"),
    LIVESTOCK_SALE("축산판매업"),
    LIVESTOCK_PROCESSING("축산가공업"),
    ANIMAL_MEDICINE_WHOLESALE_STORE("동물용의약품도매상"),
    MEAT_PACKAGING_PROCESSING("식육포장처리업"),
    LIVESTOCK_FARMING("가축사육업"),
    COMPOSITE_VIDEO_SERVICE("복합영상물제공업");

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

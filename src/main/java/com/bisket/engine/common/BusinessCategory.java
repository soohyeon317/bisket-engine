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
    COMPOSITE_VIDEO_SERVICE("복합영상물제공업"),
    GAME_DISTRIBUTION("게임물배급업"),
    GAME_PRODUCTION("게임물제작업"),
    PRINTING("인쇄사"),
    PUBLISHING("출판사"),
    MOVIE_PRODUCTION("영화제작업"),
    MOVIE_SCREENING("영화상영업"),
    MOVIE_IMPORT("영화수입업"),
    MOVIE_THEATER("영화상영관"),
    VIDEO_PRODUCTION("비디오물제작업"),
    MOVIE_DISTRIBUTION("영화배급업"),
    VIDEO_WATCHING_SERVICE("비디오물시청제공업"),
    VIDEO_LITTLE_THEATER("비디오물소극장업"),
    VIDEO_DISTRIBUTION("비디오물배급업"),
    VIDEO_ROOM("비디오물감상실업"),
    SINGING_ROOM("노래연습장업"),
    TEENAGER_GAME_SERVICE("청소년게임제공업"),
    GENERAL_GAME_SERVICE("일반게임제공업"),
    INTERNET_COMPUTER_GAME_FACILITY_SERVICE("인터넷컴퓨터게임시설제공업"),
    COMPOSITE_DISTRIBUTION_GAME_SERVICE("복합유통게임제공업"),
    POPULAR_CULTURE_ARTS_PLANNING("대중문화예술기획업"),
    ONLINE_MUSIC_SERVICE("온라인음악서비스제공업"),
    MUSIC_RECORD_VIDEO_DISTRIBUTION("음반.음악영상물배급업"),
    MUSIC_RECORD_PRODUCTION("음반물제작업"),
    MUSIC_RECORD_DISTRIBUTION("음반물배급업"),
    MUSIC_RECORD_VIDEO_PRODUCTION("음반.음악영상물제작업"),
    FOREIGNER_TOUR_CITY_ACCOMMODATION("외국인관광도시민박업"),
    FOREIGNER_AMUSEMENT_RESTAURANT("외국인전용유흥음식점업"),
    TOUR_THEATER_AMUSEMENT("관광극장유흥업"),
    TOUR_TRACK("관광궤도업"),
    INTERNATIONAL_CONFERENCE_FACILITY("국제회의시설업"),
    DOWNTOWN_CIRCULAR_TOUR("시내순환관광업"),
    TOUR_CRUISER("관광유람선업"),
    OTHER_AMUSEMENT_FACILITY("유원시설업기타"),
    TOUR_PENSION("관광펜션업"),
    MOTOR_CAMP("자동차야영장업"),
    HANOK_EXPERIENCE("한옥체험업"),
    GENERAL_AMUSEMENT_FACILITY("일반유원시설업"),
    SPECIALIZED_RECREATION("전문휴양업"),
    TOUR_STAGE("관광공연장업"),
    OVERALL_RECREATION("종합휴양업"),
    GENERAL_CAMP("일반야영장업"),
    DOMESTIC_TRAVEL("국내여행업"),
    INTERNATIONAL_CONFERENCE_PLANNING("국제회의기획업"),
    TOUR_AMUSEMENT_RESTAURANT("관광유흥음식점업"),
    TOUR_RESTAURANT("관광식당"),
    INTERNATIONAL_TRAVEL("국외여행업"),
    GENERAL_TRAVEL("일반여행업"),
    STAGE("공연장"),
    TOUR_BUSINESS_OPERATOR("관광사업자"),
    OVERALL_AMUSEMENT_FACILITY("종합유원시설업"),
    TOUR_ACCOMMODATION("관광숙박업");

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

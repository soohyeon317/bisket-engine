package com.bisket.engine.parser;

import com.bisket.engine.domain.TourRestaurant;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TourRestaurantParser {

    public static List<TourRestaurant> getListFromXml(Document xml) {
        List<TourRestaurant> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            TourRestaurant object = new TourRestaurant();

            for (int j = 0; j < childList.getLength(); j++) {
                // 데이터가 있는 애들만 출력
                if(!childList.item(j).getNodeName().equals("#text")) {
                    String itemValue = childList.item(j).getTextContent();

                    switch (j) {
                        case 3:
                            // 개방서비스명
                            object.setOpenServiceName(itemValue);
                            break;
                        case 5:
                            // 개방서비스ID
                            object.setOpenServiceId(itemValue);
                            break;
                        case 7:
                            // 개방자치단체코드
                            object.setOpenAutonomousBodyCode(itemValue);
                            break;
                        case 9:
                            // 관리번호
                            object.setManagementCode(itemValue);
                            break;
                        case 11:
                            // 인허가일자
                            object.setLicensingDate(itemValue);
                            break;
                        case 13:
                            // 인허가취소일자
                            object.setLicensingCancelDate(itemValue);
                            break;
                        case 15:
                            // 영업상태구분코드
                            object.setBusinessStatusCode(itemValue);
                            break;
                        case 17:
                            // 영업상태명
                            object.setBusinessStatusName(itemValue);
                            break;
                        case 19:
                            // 상세영업상태코드
                            object.setDetailedBusinessStatusCode(itemValue);
                            break;
                        case 21:
                            // 상세영업상태명
                            object.setDetailedBusinessStatusName(itemValue);
                            break;
                        case 23:
                            // 폐업일자
                            object.setCloseDate(itemValue);
                            break;
                        case 25:
                            // 휴업시작일자
                            object.setIdleStartDate(itemValue);
                            break;
                        case 27:
                            // 휴업종료일자
                            object.setIdleEndDate(itemValue);
                            break;
                        case 29:
                            // 재개업일자
                            object.setReopenDate(itemValue);
                            break;
                        case 31:
                            // 소재지전화
                            object.setSitePhoneNumber(itemValue);
                            break;
                        case 33:
                            // 소재지면적
                            object.setSiteArea(itemValue);
                            break;
                        case 35:
                            // 소재지우편번호
                            object.setSitePostCode(itemValue);
                            break;
                        case 37:
                            // 소재지전체주소
                            object.setSiteFullAddress(itemValue);
                            break;
                        case 39:
                            // 도로명전체주소
                            object.setRoadNameFullAddress(itemValue);
                            break;
                        case 41:
                            // 도로명우편번호
                            object.setRoadNamePostCode(itemValue);
                            break;
                        case 43:
                            // 사업장명
                            object.setBusinessPlaceName(itemValue);
                            break;
                        case 45:
                            // 최종수정시점
                            object.setLastModificationTime(itemValue);
                            break;
                        case 47:
                            // 데이터갱신구분
                            object.setDataUpdateClassification(itemValue);
                            break;
                        case 49:
                            // 데이터갱신일자
                            object.setDataUpdateDate(itemValue);
                            break;
                        case 51:
                            // 업태구분명
                            object.setBusinessCategoryClassificationName(itemValue);
                            break;
                        case 53:
                            // 좌표정보(X)
                            object.setXCoordinate(itemValue);
                            break;
                        case 55:
                            // 좌표정보(Y)
                            object.setYCoordinate(itemValue);
                            break;
                        case 57:
                            // 문화체육업종명
                            object.setCultureSportsBusinessCategoryName(itemValue);
                            break;
                        case 59:
                            // 문화사업자구분명
                            object.setCulturalBusinessOperatorClassificationName(itemValue);
                            break;
                        case 61:
                            // 지역구분명
                            object.setRegionClassificationName(itemValue);
                            break;
                        case 63:
                            // 총층수
                            object.setBuildingFloorCount(itemValue);
                            break;
                        case 65:
                            // 주변환경명
                            object.setEnvironmentName(itemValue);
                            break;
                        case 67:
                            // 제작취급품목내용
                            object.setProductionHandlingItemContent(itemValue);
                            break;
                        case 69:
                            // 보험기관명
                            object.setInsuranceOrganizationName(itemValue);
                            break;
                        case 71:
                            // 건물용도명
                            object.setBuildingUseName(itemValue);
                            break;
                        case 73:
                            // 지상층수
                            object.setGroundFloorCount(itemValue);
                            break;
                        case 75:
                            // 지하층수
                            object.setBasementFloorCount(itemValue);
                            break;
                        case 77:
                            // 객실수
                            object.setGuestRoomCount(itemValue);
                            break;
                        case 79:
                            // 건축연면적
                            object.setAnnualBuildingArea(itemValue);
                            break;
                        case 81:
                            // 영문상호명
                            object.setBusinessEnglishName(itemValue);
                            break;
                        case 83:
                            // 영문상호주소
                            object.setBusinessEnglishAddress(itemValue);
                            break;
                        case 85:
                            // 선박총톤수
                            object.setShipTonnage(itemValue);
                            break;
                        case 87:
                            // 선박척수
                            object.setShipCount(itemValue);
                            break;
                        case 89:
                            // 선박제원
                            object.setShipInformation(itemValue);
                            break;
                        case 91:
                            // 무대면적
                            object.setStageArea(itemValue);
                            break;
                        case 93:
                            // 좌석수
                            object.setSeatingCapacity(itemValue);
                            break;
                        case 95:
                            // 기념품종류
                            object.setSouvenirKind(itemValue);
                            break;
                        case 97:
                            // 회의실별동시수용인원
                            object.setMeetingRoomSeatingCapacity(itemValue);
                            break;
                        case 99:
                            // 시설면적
                            object.setFacilityArea(itemValue);
                            break;
                        case 101:
                            // 놀이기구수내역
                            object.setRideCountDetails(itemValue);
                            break;
                        case 103:
                            // 놀이시설수
                            object.setAmusementFacilityCount(itemValue);
                            break;
                        case 105:
                            // 방송시설유무
                            object.setBroadcastingFacilityFlag(itemValue);
                            break;
                        case 107:
                            // 발전시설유무
                            object.setPowerProductionFacilityFlag(itemValue);
                            break;
                        case 109:
                            // 의무실유무
                            object.setMedicalOfficeFlag(itemValue);
                            break;
                        case 111:
                            // 안내소유무
                            object.setInformationDeskFlag(itemValue);
                            break;
                        case 113:
                            // 기획여행보험시작일자
                            object.setPlannedTravelInsuranceStartDate(itemValue);
                            break;
                        case 115:
                            // 기획여행보험종료일자
                            object.setPlannedTravelInsuranceEndDate(itemValue);
                            break;
                        case 117:
                            // 자본금
                            object.setCapital(itemValue);
                            break;
                        case 119:
                            // 보험시작일자
                            object.setInsuranceStartDate(itemValue);
                            break;
                        case 121:
                            // 보험종료일자
                            object.setInsuranceEndDate(itemValue);
                            break;
                        case 123:
                            // 부대시설내역
                            object.setAdditionalFacilityDetails(itemValue);
                            break;
                        case 125:
                            // 시설규모
                            object.setFacilityScale(itemValue);
                            break;
                        default:
                            break;
                    }
                }
            }

            // 리스트에 저장
            objectList.add(object);
        }

        return objectList;
    }

}

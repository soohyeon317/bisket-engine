package com.bisket.engine.parser;

import com.bisket.engine.domain.InternetComputerGameFacilityService;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class InternetComputerGameFacilityServiceParser {

    public static List<InternetComputerGameFacilityService> getListFromXml(Document xml) {
        List<InternetComputerGameFacilityService> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            InternetComputerGameFacilityService object = new InternetComputerGameFacilityService();

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
                            object.setBusinessConditionsClassificationName(itemValue);
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
                            // 총층수
                            object.setBuildingFloorCount(itemValue);
                            break;
                        case 63:
                            // 주변환경명
                            object.setEnvironmentName(itemValue);
                            break;
                        case 65:
                            // 제작취급품목내용
                            object.setProductionHandlingItemContent(itemValue);
                            break;
                        case 67:
                            // 시설면적
                            object.setFacilityArea(itemValue);
                            break;
                        case 69:
                            // 지상층수
                            object.setGroundFloorCount(itemValue);
                            break;
                        case 71:
                            // 지하층수
                            object.setBasementFloorCount(itemValue);
                            break;
                        case 73:
                            // 건물용도명
                            object.setBuildingUseName(itemValue);
                            break;
                        case 75:
                            // 통로너비
                            object.setPassageBreadth(itemValue);
                            break;
                        case 77:
                            // 조명시설조도
                            object.setLightingFacilityIlluminance(itemValue);
                            break;
                        case 79:
                            // 노래방실수
                            object.setSingingRoomCount(itemValue);
                            break;
                        case 81:
                            // 청소년실수
                            object.setTeenagerRoomCount(itemValue);
                            break;
                        case 83:
                            // 비상계단여부
                            object.setEmergencyStairsFlag(itemValue);
                            break;
                        case 85:
                            // 비상구여부
                            object.setEmergencyExitFlag(itemValue);
                            break;
                        case 87:
                            // 자동환기여부
                            object.setAutoVentilationFlag(itemValue);
                            break;
                        case 89:
                            // 청소년실여부
                            object.setTeenagerRoomFlag(itemValue);
                            break;
                        case 91:
                            // 특수조명여부
                            object.setSpecialLightingFlag(itemValue);
                            break;
                        case 93:
                            // 방음시설여부
                            object.setSoundIsolationFacilityFlag(itemValue);
                            break;
                        case 95:
                            // 비디오재생기명
                            object.setVcrName(itemValue);
                            break;
                        case 97:
                            // 조명시설유무
                            object.setLightingFacilityFlag(itemValue);
                            break;
                        case 99:
                            // 음향시설여부
                            object.setSoundFacilityFlag(itemValue);
                            break;
                        case 101:
                            // 편의시설여부
                            object.setConvenienceFacilityFlag(itemValue);
                            break;
                        case 103:
                            // 소방시설여부
                            object.setFireProtectionFacilityFlag(itemValue);
                            break;
                        case 105:
                            // 총게임기수
                            object.setGameDeviceCount(itemValue);
                            break;
                        case 107:
                            // 기존게임업외업종명
                            object.setOtherBusinessCategoryName(itemValue);
                            break;
                        case 109:
                            // 제공게임물명
                            object.setProvisionGameName(itemValue);
                            break;
                        case 111:
                            // 공연장형태구분명
                            object.setStageFormClassificationName(itemValue);
                            break;
                        case 113:
                            // 품목명
                            object.setItemName(itemValue);
                            break;
                        case 115:
                            // 최초등록시점
                            object.setFirstRegistrationTime(itemValue);
                            break;
                        case 117:
                            // 지역구분명
                            object.setRegionClassificationName(itemValue);
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

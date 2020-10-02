package com.bisket.engine.parser;

import com.bisket.engine.domain.KaraokeBar;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class KaraokeBarParser {

    public static List<KaraokeBar> getListFromXml(Document xml) {
        List<KaraokeBar> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            KaraokeBar object = new KaraokeBar();

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
                            // 위생업태명
                            object.setSanitaryBusinessCategoryName(itemValue);
                            break;
                        case 59:
                            // 남성종사자수
                            object.setMaleWorkerCount(itemValue);
                            break;
                        case 61:
                            // 여성종사자수
                            object.setFemaleWorkerCount(itemValue);
                            break;
                        case 63:
                            // 영업장주변구분명
                            object.setBusinessPlaceEnvironmentClassificationName(itemValue);
                            break;
                        case 65:
                            // 등급구분명
                            object.setGradeClassificationName(itemValue);
                            break;
                        case 67:
                            // 급수시설구분명
                            object.setWaterSupplyFacilityClassificationName(itemValue);
                            break;
                        case 69:
                            // 총종업원수
                            object.setEmployeeCount(itemValue);
                            break;
                        case 71:
                            // 본사종업원수
                            object.setHeadOfficeEmployeeCount(itemValue);
                            break;
                        case 73:
                            // 공장사무직종업원수
                            object.setFactoryOfficeEmployeeCount(itemValue);
                            break;
                        case 75:
                            // 공장판매직종업원수
                            object.setFactorySaleEmployeeCount(itemValue);
                            break;
                        case 77:
                            // 공장생산직종업원수
                            object.setFactoryProductionEmployeeCount(itemValue);
                            break;
                        case 79:
                            // 건물소유구분명
                            object.setBuildingPossessionClassificationName(itemValue);
                            break;
                        case 81:
                            // 보증액
                            object.setDeposit(itemValue);
                            break;
                        case 83:
                            // 월세액
                            object.setMonthlyRent(itemValue);
                            break;
                        case 85:
                            // 다중이용업소여부
                            object.setPubliclyUsedBusinessPlaceFlag(itemValue);
                            break;
                        case 87:
                            // 시설총규모
                            object.setFacilityScale(itemValue);
                            break;
                        case 89:
                            // 전통업소지정번호
                            object.setTraditionalBusinessPlaceAppointmentNumber(itemValue);
                            break;
                        case 91:
                            // 전통업소주된음식
                            object.setTraditionalBusinessPlaceMainFood(itemValue);
                            break;
                        case 93:
                            // 홈페이지
                            object.setHomepage(itemValue);
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

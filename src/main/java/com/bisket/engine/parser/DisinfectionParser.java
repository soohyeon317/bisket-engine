package com.bisket.engine.parser;

import com.bisket.engine.domain.Disinfection;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DisinfectionParser {

    public static List<Disinfection> getListFromXml(Document xml) {
        List<Disinfection> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            Disinfection object = new Disinfection();

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
                            object.setBusinessTypeClassificationName(itemValue);
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
                            // 사무실면적
                            object.setOfficeArea(itemValue);
                            break;
                        case 59:
                            // 소독차량차고면적
                            object.setDisinfectionVehicleGarageArea(itemValue);
                            break;
                        case 61:
                            // 초미립자살포기수
                            object.setUltrafineParticleSpreaderCount(itemValue);
                            break;
                        case 63:
                            // 휴대용소독기수
                            object.setPortableDisinfectorCount(itemValue);
                            break;
                        case 65:
                            // 동력분무기수
                            object.setPowerSprayerCount(itemValue);
                            break;
                        case 67:
                            // 수동식분무기수
                            object.setHandSprayerCount(itemValue);
                            break;
                        case 69:
                            // 방독면수
                            object.setGasMaskCount(itemValue);
                            break;
                        case 71:
                            // 보호안경수
                            object.setProtectiveGlassesCount(itemValue);
                            break;
                        case 73:
                            // 보호용의복수
                            object.setProtectiveClothingCount(itemValue);
                            break;
                        case 75:
                            // 진공청소기수
                            object.setVacuumCleanerCount(itemValue);
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

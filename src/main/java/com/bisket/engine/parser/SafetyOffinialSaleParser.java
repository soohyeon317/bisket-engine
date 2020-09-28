package com.bisket.engine.parser;

import com.bisket.engine.domain.SafetyOfficinalSale;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SafetyOffinialSaleParser {

    public static List<SafetyOfficinalSale> getSafetyOffinialSaleListFromXml(Document xml) {
        List<SafetyOfficinalSale> safetyOfficinalSaleList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            SafetyOfficinalSale safetyOfficinalSale = new SafetyOfficinalSale();

            for (int j = 0; j < childList.getLength(); j++) {
                // 데이터가 있는 애들만 출력
                if(!childList.item(j).getNodeName().equals("#text")) {
                    String itemValue = childList.item(j).getTextContent();

                    switch (j) {
                        case 3:
                            // 개방서비스명
                            safetyOfficinalSale.setOpenServiceName(itemValue);
                            break;
                        case 5:
                            // 개방서비스ID
                            safetyOfficinalSale.setOpenServiceId(itemValue);
                            break;
                        case 7:
                            // 개방자치단체코드
                            safetyOfficinalSale.setOpenAutonomousEntityCode(itemValue);
                            break;
                        case 9:
                            // 관리번호
                            safetyOfficinalSale.setManagementCode(itemValue);
                            break;
                        case 11:
                            // 인허가일자
                            safetyOfficinalSale.setLicensingDate(itemValue);
                            break;
                        case 13:
                            // 인허가취소일자
                            safetyOfficinalSale.setLicensingCancelDate(itemValue);
                            break;
                        case 15:
                            // 영업상태구분코드
                            safetyOfficinalSale.setBusinessStatusCode(itemValue);
                            break;
                        case 17:
                            // 영업상태명
                            safetyOfficinalSale.setBusinessStatusName(itemValue);
                            break;
                        case 19:
                            // 상세영업상태코드
                            safetyOfficinalSale.setDetailedBusinessStatusCode(itemValue);
                            break;
                        case 21:
                            // 상세영업상태명
                            safetyOfficinalSale.setDetailedBusinessStatusName(itemValue);
                            break;
                        case 23:
                            // 폐업일자
                            safetyOfficinalSale.setCloseDate(itemValue);
                            break;
                        case 25:
                            // 휴업시작일자
                            safetyOfficinalSale.setIdleStartDate(itemValue);
                            break;
                        case 27:
                            // 휴업종료일자
                            safetyOfficinalSale.setIdleEndDate(itemValue);
                            break;
                        case 29:
                            // 재개업일자
                            safetyOfficinalSale.setReopenDate(itemValue);
                            break;
                        case 31:
                            // 소재지전화
                            safetyOfficinalSale.setSitePhoneNumber(itemValue);
                            break;
                        case 33:
                            // 소재지면적
                            safetyOfficinalSale.setSiteArea(itemValue);
                            break;
                        case 35:
                            // 소재지우편번호
                            safetyOfficinalSale.setSitePostCode(itemValue);
                            break;
                        case 37:
                            // 소재지전체주소
                            safetyOfficinalSale.setSiteFullAddress(itemValue);
                            break;
                        case 39:
                            // 도로명전체주소
                            safetyOfficinalSale.setRoadNameFullAddress(itemValue);
                            break;
                        case 41:
                            // 도로명우편번호
                            safetyOfficinalSale.setRoadNamePostCode(itemValue);
                            break;
                        case 43:
                            // 사업장명
                            safetyOfficinalSale.setBusinessPlaceName(itemValue);
                            break;
                        case 45:
                            // 최종수정시점
                            safetyOfficinalSale.setLastModificationTime(itemValue);
                            break;
                        case 47:
                            // 데이터갱신구분
                            safetyOfficinalSale.setDataUpdateClassification(itemValue);
                            break;
                        case 49:
                            // 데이터갱신일자
                            safetyOfficinalSale.setDataUpdateDate(itemValue);
                            break;
                        case 51:
                            // 업태구분명
                            safetyOfficinalSale.setBusinessConditionsName(itemValue);
                            break;
                        case 53:
                            // 좌표정보(X)
                            safetyOfficinalSale.setXCoordinate(itemValue);
                            break;
                        case 55:
                            // 좌표정보(Y)
                            safetyOfficinalSale.setYCoordinate(itemValue);
                            break;
                        case 57:
                            // 판매점영업면적
                            safetyOfficinalSale.setStoreBusinessArea(itemValue);
                            break;
                        default:
                            break;
                    }
                }
            }

            // 리스트에 저장
            safetyOfficinalSaleList.add(safetyOfficinalSale);
        }

        return safetyOfficinalSaleList;
    }

}

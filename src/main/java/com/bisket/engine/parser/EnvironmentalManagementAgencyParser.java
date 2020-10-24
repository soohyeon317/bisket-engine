package com.bisket.engine.parser;

import com.bisket.engine.entity.EnvironmentalManagementAgency;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EnvironmentalManagementAgencyParser {

    public static List<EnvironmentalManagementAgency> getListFromXml(Document xml) {
        List<EnvironmentalManagementAgency> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            EnvironmentalManagementAgency object = new EnvironmentalManagementAgency();

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
                            // 실험실면적
                            object.setLaboratoryArea(itemValue);
                            break;
                        case 59:
                            // 사업장구분명
                            object.setBusinessPlaceClassificationName(itemValue);
                            break;
                        case 61:
                            // 영업소면적
                            object.setBusinessPlaceArea(itemValue);
                            break;
                        case 63:
                            // 위탁업체명
                            object.setConsignmentBusinessName(itemValue);
                            break;
                        case 65:
                            // 실험실지역코드
                            object.setLaboratoryRegionCode(itemValue);
                            break;
                        case 67:
                            // 실험실우편번호
                            object.setLaboratoryPostCode(itemValue);
                            break;
                        case 69:
                            // 실험실산
                            object.setLaboratoryAddressSan(itemValue);
                            break;
                        case 71:
                            // 실험실번지
                            object.setLaboratoryAddressBeonji(itemValue);
                            break;
                        case 73:
                            // 실험실호
                            object.setLaboratoryAddressHo(itemValue);
                            break;
                        case 75:
                            // 실험실통
                            object.setLaboratoryAddressTong(itemValue);
                            break;
                        case 77:
                            // 실험실반
                            object.setLaboratoryAddressBan(itemValue);
                            break;
                        case 79:
                            // 실험실특수주소
                            object.setLaboratorySpecialAddress(itemValue);
                            break;
                        case 81:
                            // 실험실특수주소동
                            object.setLaboratorySpecialAddressDong(itemValue);
                            break;
                        case 83:
                            // 실험실특수주소호
                            object.setLaboratorySpecialAddressHo(itemValue);
                            break;
                        case 85:
                            // 실험실도로명주소시군구코드
                            object.setLaboratoryRoadNameAddressSiGunGuCode(itemValue);
                            break;
                        case 87:
                            // 실험실도로명주소읍면동코드
                            object.setLaboratoryRoadNameAddressEupMyeonDongCode(itemValue);
                            break;
                        case 89:
                            // 실험실도로명주소읍면동구분
                            object.setLaboratoryRoadNameAddressEupMyeonDongClassification(itemValue);
                            break;
                        case 91:
                            // 실험실도로명주소코드
                            object.setLaboratoryRoadNameAddressCode(itemValue);
                            break;
                        case 93:
                            // 실험실도로명특수주소
                            object.setLaboratoryRoadNameSpecialAddress(itemValue);
                            break;
                        case 95:
                            // 실험실도로명주소건물층구분
                            object.setLaboratoryRoadNameAddressBuildingFloorClassification(itemValue);
                            break;
                        case 97:
                            // 실험실도로명주소건물본번호
                            object.setLaboratoryRoadNameAddressBuildingOriginalNumber(itemValue);
                            break;
                        case 99:
                            // 실험실도로명주소건물부번호
                            object.setLaboratoryRoadNameAddressBuildingSubNumber(itemValue);
                            break;
                        case 101:
                            // 실험실도로명주소우편번호
                            object.setLaboratoryRoadNameAddressPostCode(itemValue);
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

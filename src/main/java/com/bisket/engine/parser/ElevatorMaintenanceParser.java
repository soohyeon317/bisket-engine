package com.bisket.engine.parser;

import com.bisket.engine.entity.ElevatorMaintenance;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ElevatorMaintenanceParser {

    public static List<ElevatorMaintenance> getListFromXml(Document xml) {
        List<ElevatorMaintenance> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            ElevatorMaintenance object = new ElevatorMaintenance();

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
                            // 업종구분명
                            object.setBusinessLineClassificationName(itemValue);
                            break;
                        case 59:
                            // 관리업구분명
                            object.setManagementBusinessClassificationName(itemValue);
                            break;
                        case 61:
                            // 자본금
                            object.setCapital(itemValue);
                            break;
                        case 63:
                            // 자산
                            object.setCapital(itemValue);
                            break;
                        case 65:
                            // 보수범위
                            object.setMaintenanceRange(itemValue);
                            break;
                        case 67:
                            // 유지관리책임인력수
                            object.setMaintenanceManCount(itemValue);
                            break;
                        case 69:
                            // 실무기술인력수
                            object.setPracticalTechnicianCount(itemValue);
                            break;
                        case 71:
                            // 설계책임기술인력수
                            object.setDesignTechnicianCount(itemValue);
                            break;
                        case 73:
                            // 제조책임기술인력수
                            object.setManufacturingTechnicianCount(itemValue);
                            break;
                        case 75:
                            // 임원수
                            object.setOfficialCount(itemValue);
                            break;
                        case 77:
                            // 총직원수
                            object.setStaffCount(itemValue);
                            break;
                        case 79:
                            // 기술직직원수
                            object.setTechnicalPostStaffCount(itemValue);
                            break;
                        case 81:
                            // 기능직직원수
                            object.setSkillPostStaffCount(itemValue);
                            break;
                        case 83:
                            // 사무직직원수
                            object.setOfficeStaffCount(itemValue);
                            break;
                        case 85:
                            // 기타직원수
                            object.setOtherStaffCount(itemValue);
                            break;
                        case 87:
                            // 회사구분명
                            object.setCompanyClassificationName(itemValue);
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

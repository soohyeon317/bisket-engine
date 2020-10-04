package com.bisket.engine.parser;

import com.bisket.engine.domain.Accommodation;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AccommodationParser {

    public static List<Accommodation> getListFromXml(Document xml) {
        List<Accommodation> objectList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            Accommodation object = new Accommodation();

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
                            // 위생업태명
                            object.setSanitationBusinessTypeName(itemValue);
                            break;
                        case 59:
                            // 건물지상층수
                            object.setGroundFloorCount(itemValue);
                            break;
                        case 61:
                            // 건물지하층수
                            object.setBasementFloorCount(itemValue);
                            break;
                        case 63:
                            // 사용시작지상층
                            object.setUseStartGroundFloor(itemValue);
                            break;
                        case 65:
                            // 사용끝지상층
                            object.setUseEndGroundFloor(itemValue);
                            break;
                        case 67:
                            // 사용시작지하층
                            object.setUseStartBasementFloor(itemValue);
                            break;
                        case 69:
                            // 사용끝지하층
                            object.setUseEndBasementFloor(itemValue);
                            break;
                        case 71:
                            // 한실수
                            object.setKoreanStyleRoomCount(itemValue);
                            break;
                        case 73:
                            // 양실수
                            object.setWesternStyleRoomCount(itemValue);
                            break;
                        case 75:
                            // 욕실수
                            object.setBathRoomCount(itemValue);
                            break;
                        case 77:
                            // 발한실여부
                            object.setSweatingRoomFlag(itemValue);
                            break;
                        case 79:
                            // 좌석수
                            object.setSeatingCapacity(itemValue);
                            break;
                        case 81:
                            // 조건부허가신고사유
                            object.setConditionalApprovalRegistrationReason(itemValue);
                            break;
                        case 83:
                            // 조건부허가시작일자
                            object.setConditionalApprovalStartDate(itemValue);
                            break;
                        case 85:
                            // 조건부허가종료일자
                            object.setConditionalApprovalEndDate(itemValue);
                            break;
                        case 87:
                            // 건물소유구분명
                            object.setBuildingPossessionClassificationName(itemValue);
                            break;
                        case 89:
                            // 세탁기수
                            object.setWashingMachineCount(itemValue);
                            break;
                        case 91:
                            // 여성종사자수
                            object.setFemaleWorkerCount(itemValue);
                            break;
                        case 93:
                            // 남성종사자수
                            object.setMaleWorkerCount(itemValue);
                            break;
                        case 95:
                            // 회수건조수
                            object.setRecoveringDryerCount(itemValue);
                            break;
                        case 97:
                            // 침대수
                            object.setBedCount(itemValue);
                            break;
                        case 99:
                            // 다중이용업소여부
                            object.setPubliclyUsedBusinessPlaceFlag(itemValue);
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

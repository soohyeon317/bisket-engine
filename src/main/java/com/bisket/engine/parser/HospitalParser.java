package com.bisket.engine.parser;

import com.bisket.engine.domain.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HospitalParser {

    public static List<Hospital> getListFromXml(Document xml) {
        List<Hospital> hospitalList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            Hospital hospital = new Hospital();

            for (int j = 0; j < childList.getLength(); j++) {
                // 데이터가 있는 애들만 출력
                if(!childList.item(j).getNodeName().equals("#text")) {
                    String itemValue = childList.item(j).getTextContent();

                    switch (j) {
                        case 3:
                            // 개방서비스명
                            hospital.setOpenServiceName(itemValue);
                            break;
                        case 5:
                            // 개방서비스ID
                            hospital.setOpenServiceId(itemValue);
                            break;
                        case 7:
                            // 개방자치단체코드
                            hospital.setOpenAutonomousEntityCode(itemValue);
                            break;
                        case 9:
                            // 관리번호
                            hospital.setManagementCode(itemValue);
                            break;
                        case 11:
                            // 인허가일자
                            hospital.setLicensingDate(itemValue);
                            break;
                        case 13:
                            // 인허가취소일자
                            hospital.setLicensingCancelDate(itemValue);
                            break;
                        case 15:
                            // 영업상태구분코드
                            hospital.setBusinessStatusCode(itemValue);
                            break;
                        case 17:
                            // 영업상태명
                            hospital.setBusinessStatusName(itemValue);
                            break;
                        case 19:
                            // 상세영업상태코드
                            hospital.setDetailedBusinessStatusCode(itemValue);
                            break;
                        case 21:
                            // 상세영업상태명
                            hospital.setDetailedBusinessStatusName(itemValue);
                            break;
                        case 23:
                            // 폐업일자
                            hospital.setCloseDate(itemValue);
                            break;
                        case 25:
                            // 휴업시작일자
                            hospital.setIdleStartDate(itemValue);
                            break;
                        case 27:
                            // 휴업종료일자
                            hospital.setIdleEndDate(itemValue);
                            break;
                        case 29:
                            // 재개업일자
                            hospital.setReopenDate(itemValue);
                            break;
                        case 31:
                            // 소재지전화
                            hospital.setSitePhoneNumber(itemValue);
                            break;
                        case 33:
                            // 소재지면적
                            hospital.setSiteArea(itemValue);
                            break;
                        case 35:
                            // 소재지우편번호
                            hospital.setSitePostCode(itemValue);
                            break;
                        case 37:
                            // 소재지전체주소
                            hospital.setSiteFullAddress(itemValue);
                            break;
                        case 39:
                            // 도로명전체주소
                            hospital.setRoadNameFullAddress(itemValue);
                            break;
                        case 41:
                            // 도로명우편번호
                            hospital.setRoadNamePostCode(itemValue);
                            break;
                        case 43:
                            // 사업장명
                            hospital.setBusinessPlaceName(itemValue);
                            break;
                        case 45:
                            // 최종수정시점
                            hospital.setLastModificationTime(itemValue);
                            break;
                        case 47:
                            // 데이터갱신구분
                            hospital.setDataUpdateClassification(itemValue);
                            break;
                        case 49:
                            // 데이터갱신일자
                            hospital.setDataUpdateDate(itemValue);
                            break;
                        case 51:
                            // 업태구분명
                            hospital.setBusinessConditionsClassificationName(itemValue);
                            break;
                        case 53:
                            // 좌표정보(X)
                            hospital.setXCoordinate(itemValue);
                            break;
                        case 55:
                            // 좌표정보(Y)
                            hospital.setYCoordinate(itemValue);
                            break;
                        case 57:
                            // 의료기관종별명
                            hospital.setMedicalOrganizationAssortmentName(itemValue);
                            break;
                        case 59:
                            // 의료인수
                            hospital.setMedicalPersonnelCount(itemValue);
                            break;
                        case 61:
                            // 입원실수
                            hospital.setHospitalRoomCount(itemValue);
                            break;
                        case 63:
                            // 병상수
                            hospital.setSickbedCount(itemValue);
                            break;
                        case 65:
                            // 총면적
                            hospital.setTotalArea(itemValue);
                            break;
                        case 67:
                            // 진료과목내용
                            hospital.setTreatmentSubjectCode(itemValue);
                            break;
                        case 69:
                            // 진료과목내용명
                            hospital.setTreatmentSubjectName(itemValue);
                            break;
                        case 71:
                            // 지정취소일자
                            hospital.setAssignmentCancelDate(itemValue);
                            break;
                        case 73:
                            // 완화의료지정형태
                            hospital.setPalliativeMedicineAssignmentType(itemValue);
                            break;
                        case 75:
                            // 완화의료담당부서명
                            hospital.setPalliativeMedicineDepartmentName(itemValue);
                            break;
                        case 77:
                            // 구급차특수
                            hospital.setSpecialAmbulanceCount(itemValue);
                            break;
                        case 79:
                            // 구급차일반
                            hospital.setGeneralAmbulanceCount(itemValue);
                            break;
                        case 81:
                            // 총인원
                            hospital.setEmployeeCount(itemValue);
                            break;
                        case 83:
                            // 구조사수
                            hospital.setParamedicCount(itemValue);
                            break;
                        case 85:
                            // 허가병상수
                            hospital.setAllowedSickbedCount(itemValue);
                            break;
                        case 87:
                            // 최초지정일자
                            hospital.setFirstAssignmentDate(itemValue);
                            break;
                        default:
                            break;
                    }
                }
            }

            // 리스트에 저장
            hospitalList.add(hospital);
        }

        return hospitalList;
    }

}

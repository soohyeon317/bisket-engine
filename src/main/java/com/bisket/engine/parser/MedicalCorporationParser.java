package com.bisket.engine.parser;

import com.bisket.engine.domain.MedicalCorporation;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MedicalCorporationParser {

    public static List<MedicalCorporation> getListFromXml(Document xml) {
        List<MedicalCorporation> MedicalCorporationList = new ArrayList<>();

        // root element 구하기
        Element element = xml.getDocumentElement();
        NodeList rowList = element.getElementsByTagName("row");

        for (int i = 0; i < rowList.getLength(); i++) {
            NodeList childList = rowList.item(i).getChildNodes();
            MedicalCorporation medicalCorporation = new MedicalCorporation();

            for (int j = 0; j < childList.getLength(); j++) {
                // 데이터가 있는 애들만 출력
                if(!childList.item(j).getNodeName().equals("#text")) {
                    String itemValue = childList.item(j).getTextContent();

                    switch (j) {
                        case 3:
                            // 개방서비스명
                            medicalCorporation.setOpenServiceName(itemValue);
                            break;
                        case 5:
                            // 개방서비스ID
                            medicalCorporation.setOpenServiceId(itemValue);
                            break;
                        case 7:
                            // 개방자치단체코드
                            medicalCorporation.setOpenAutonomousEntityCode(itemValue);
                            break;
                        case 9:
                            // 관리번호
                            medicalCorporation.setManagementCode(itemValue);
                            break;
                        case 11:
                            // 인허가일자
                            medicalCorporation.setLicensingDate(itemValue);
                            break;
                        case 13:
                            // 인허가취소일자
                            medicalCorporation.setLicensingCancelDate(itemValue);
                            break;
                        case 15:
                            // 영업상태구분코드
                            medicalCorporation.setBusinessStatusCode(itemValue);
                            break;
                        case 17:
                            // 영업상태명
                            medicalCorporation.setBusinessStatusName(itemValue);
                            break;
                        case 19:
                            // 상세영업상태코드
                            medicalCorporation.setDetailedBusinessStatusCode(itemValue);
                            break;
                        case 21:
                            // 상세영업상태명
                            medicalCorporation.setDetailedBusinessStatusName(itemValue);
                            break;
                        case 23:
                            // 폐업일자
                            medicalCorporation.setCloseDate(itemValue);
                            break;
                        case 25:
                            // 휴업시작일자
                            medicalCorporation.setIdleStartDate(itemValue);
                            break;
                        case 27:
                            // 휴업종료일자
                            medicalCorporation.setIdleEndDate(itemValue);
                            break;
                        case 29:
                            // 재개업일자
                            medicalCorporation.setReopenDate(itemValue);
                            break;
                        case 31:
                            // 소재지전화
                            medicalCorporation.setSitePhoneNumber(itemValue);
                            break;
                        case 33:
                            // 소재지면적
                            medicalCorporation.setSiteArea(itemValue);
                            break;
                        case 35:
                            // 소재지우편번호
                            medicalCorporation.setSitePostCode(itemValue);
                            break;
                        case 37:
                            // 소재지전체주소
                            medicalCorporation.setSiteFullAddress(itemValue);
                            break;
                        case 39:
                            // 도로명전체주소
                            medicalCorporation.setRoadNameFullAddress(itemValue);
                            break;
                        case 41:
                            // 도로명우편번호
                            medicalCorporation.setRoadNamePostCode(itemValue);
                            break;
                        case 43:
                            // 사업장명
                            medicalCorporation.setBusinessPlaceName(itemValue);
                            break;
                        case 45:
                            // 최종수정시점
                            medicalCorporation.setLastModificationTime(itemValue);
                            break;
                        case 47:
                            // 데이터갱신구분
                            medicalCorporation.setDataUpdateClassification(itemValue);
                            break;
                        case 49:
                            // 데이터갱신일자
                            medicalCorporation.setDataUpdateDate(itemValue);
                            break;
                        case 51:
                            // 업태구분명
                            medicalCorporation.setBusinessConditionsClassificationName(itemValue);
                            break;
                        case 53:
                            // 좌표정보(X)
                            medicalCorporation.setXCoordinate(itemValue);
                            break;
                        case 55:
                            // 좌표정보(Y)
                            medicalCorporation.setYCoordinate(itemValue);
                            break;
                        case 57:
                            // 의료기관종별명
                            medicalCorporation.setMedicalOrganizationAssortmentName(itemValue);
                            break;
                        case 59:
                            // 의료인수
                            medicalCorporation.setMedicalPersonnelCount(itemValue);
                            break;
                        case 61:
                            // 입원실수
                            medicalCorporation.setHospitalRoomCount(itemValue);
                            break;
                        case 63:
                            // 병상수
                            medicalCorporation.setSickbedCount(itemValue);
                            break;
                        case 65:
                            // 총면적
                            medicalCorporation.setTotalArea(itemValue);
                            break;
                        case 67:
                            // 진료과목내용
                            medicalCorporation.setTreatmentSubjectCode(itemValue);
                            break;
                        case 69:
                            // 진료과목내용명
                            medicalCorporation.setTreatmentSubjectName(itemValue);
                            break;
                        case 71:
                            // 지정취소일자
                            medicalCorporation.setAssignmentCancelDate(itemValue);
                            break;
                        case 73:
                            // 완화의료지정형태
                            medicalCorporation.setPalliativeMedicineAssignmentType(itemValue);
                            break;
                        case 75:
                            // 완화의료담당부서명
                            medicalCorporation.setPalliativeMedicineDepartmentName(itemValue);
                            break;
                        case 77:
                            // 구급차특수
                            medicalCorporation.setSpecialAmbulanceCount(itemValue);
                            break;
                        case 79:
                            // 구급차일반
                            medicalCorporation.setGeneralAmbulanceCount(itemValue);
                            break;
                        case 81:
                            // 총인원
                            medicalCorporation.setEmployeeCount(itemValue);
                            break;
                        case 83:
                            // 구조사수
                            medicalCorporation.setParamedicCount(itemValue);
                            break;
                        case 85:
                            // 허가병상수
                            medicalCorporation.setAllowedSickbedCount(itemValue);
                            break;
                        case 87:
                            // 최초지정일자
                            medicalCorporation.setFirstAssignmentDate(itemValue);
                            break;
                        default:
                            break;
                    }
                }
            }

            // 리스트에 저장
            MedicalCorporationList.add(medicalCorporation);
        }

        return MedicalCorporationList;
    }

}

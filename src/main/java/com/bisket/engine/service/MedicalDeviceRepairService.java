package com.bisket.engine.service;

import com.bisket.engine.domain.MedicalDeviceRepair;
import com.bisket.engine.parser.MedicalDeviceRepairParser;
import com.bisket.engine.repository.MedicalDeviceRepairRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@Slf4j
public class MedicalDeviceRepairService {
    private final MedicalDeviceRepairRepository medicalDeviceRepairRepository;

    public MedicalDeviceRepairService(MedicalDeviceRepairRepository medicalDeviceRepairRepository) {
        this.medicalDeviceRepairRepository = medicalDeviceRepairRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<MedicalDeviceRepair> parsedList = MedicalDeviceRepairParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, MedicalDeviceRepair> managementCodeToParsedObjectMap = new HashMap<>();
            for (MedicalDeviceRepair parsed : parsedList) {
                String parsedManagementCode = parsed.getManagementCode();
                if (!managementCodeToParsedObjectMap.containsKey(parsedManagementCode)) {
                    managementCodeToParsedObjectMap.put(parsed.getManagementCode(), parsed);
                } else {
                    // 관리코드 중복건은 순서상 가장 나중인 것을 리스트에서 제거
                    parsedList.remove(parsed);
                    break;
                }
            }
            Map<String, MedicalDeviceRepair> managementCodeToFoundObjectMap = new HashMap<>();
            List<MedicalDeviceRepair> foundList = medicalDeviceRepairRepository.findAll();
            if (!foundList.isEmpty()) {
                for (MedicalDeviceRepair found : foundList) {
                    managementCodeToFoundObjectMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                MedicalDeviceRepair parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToFoundObjectMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    MedicalDeviceRepair found = managementCodeToFoundObjectMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    medicalDeviceRepairRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

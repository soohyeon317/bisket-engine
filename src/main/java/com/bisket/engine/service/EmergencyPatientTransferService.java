package com.bisket.engine.service;

import com.bisket.engine.domain.EmergencyPatientTransfer;
import com.bisket.engine.parser.EmergencyPatientTransferParser;
import com.bisket.engine.repository.EmergencyPatientTransferRepository;
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
public class EmergencyPatientTransferService {
    private final EmergencyPatientTransferRepository emergencyPatientTransferRepository;

    public EmergencyPatientTransferService(EmergencyPatientTransferRepository emergencyPatientTransferRepository) {
        this.emergencyPatientTransferRepository = emergencyPatientTransferRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<EmergencyPatientTransfer> parsedList = EmergencyPatientTransferParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, EmergencyPatientTransfer> managementCodeToClinicMap = new HashMap<>();
            List<EmergencyPatientTransfer> foundList = emergencyPatientTransferRepository.findAll();
            if (!foundList.isEmpty()) {
                for (EmergencyPatientTransfer found : foundList) {
                    managementCodeToClinicMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                EmergencyPatientTransfer parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nEmergencyPatientTransfer\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToClinicMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    EmergencyPatientTransfer found = managementCodeToClinicMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    emergencyPatientTransferRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

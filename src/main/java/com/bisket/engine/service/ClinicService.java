package com.bisket.engine.service;

import com.bisket.engine.domain.Clinic;
import com.bisket.engine.parser.ClinicParser;
import com.bisket.engine.repository.ClinicRepository;
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
public class ClinicService {
    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<Clinic> parsedList = ClinicParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, Clinic> managementCodeToClinicMap = new HashMap<>();
            List<Clinic> foundList = clinicRepository.findAll();
            if (!foundList.isEmpty()) {
                for (Clinic found : foundList) {
                    managementCodeToClinicMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                Clinic parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nClinic\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToClinicMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    Clinic found = managementCodeToClinicMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    clinicRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

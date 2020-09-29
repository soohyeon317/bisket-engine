package com.bisket.engine.service;

import com.bisket.engine.domain.Hospital;
import com.bisket.engine.parser.HospitalParser;
import com.bisket.engine.repository.HospitalRepository;
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
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<Hospital> parsedList = HospitalParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, Hospital> managementCodeToObjectMap = new HashMap<>();
            List<Hospital> foundList = hospitalRepository.findAll();
            if (!foundList.isEmpty()) {
                for (Hospital found : foundList) {
                    managementCodeToObjectMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                Hospital parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToObjectMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    Hospital found = managementCodeToObjectMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    hospitalRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

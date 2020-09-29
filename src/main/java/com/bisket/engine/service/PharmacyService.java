package com.bisket.engine.service;

import com.bisket.engine.domain.Pharmacy;
import com.bisket.engine.parser.PharmacyParser;
import com.bisket.engine.repository.PharmacyRepository;
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
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<Pharmacy> parsedList = PharmacyParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, Pharmacy> managementCodeToObjectMap = new HashMap<>();
            List<Pharmacy> foundList = pharmacyRepository.findAll();
            if (!foundList.isEmpty()) {
                for (Pharmacy found : foundList) {
                    managementCodeToObjectMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                Pharmacy parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToObjectMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    Pharmacy found = managementCodeToObjectMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    pharmacyRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

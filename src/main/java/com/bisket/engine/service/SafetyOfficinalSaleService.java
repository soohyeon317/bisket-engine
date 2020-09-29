package com.bisket.engine.service;

import com.bisket.engine.domain.SafetyOfficinalSale;
import com.bisket.engine.parser.SafetyOffinialSaleParser;
import com.bisket.engine.repository.SafetyOfficinalSaleRepository;
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
public class SafetyOfficinalSaleService {
    private final SafetyOfficinalSaleRepository safetyOfficinalSaleRepository;

    public SafetyOfficinalSaleService(SafetyOfficinalSaleRepository safetyOfficinalSaleRepository) {
        this.safetyOfficinalSaleRepository = safetyOfficinalSaleRepository;
    }

    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws IOException, ParserConfigurationException, SAXException {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<SafetyOfficinalSale> parsedList = SafetyOffinialSaleParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, SafetyOfficinalSale> managementCodeToSafetyOfficinalSaleMap = new HashMap<>();
            List<SafetyOfficinalSale> foundList = safetyOfficinalSaleRepository.findAll();
            if (!foundList.isEmpty()) {
                for (SafetyOfficinalSale found : foundList) {
                    managementCodeToSafetyOfficinalSaleMap.put(found.getManagementCode(), found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                SafetyOfficinalSale parsed = parsedList.get(i);
                String managementCode = parsed.getManagementCode();
                log.info("=======\nSafetyOfficinalSale\nSequence: {}\nManagementCode: {}", i+1, managementCode);
                if (managementCodeToSafetyOfficinalSaleMap.containsKey(managementCode)) {
                    /* 업데이트 진행 */
                    SafetyOfficinalSale found = managementCodeToSafetyOfficinalSaleMap.get(managementCode);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    safetyOfficinalSaleRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

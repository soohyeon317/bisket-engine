package com.bisket.engine.service;

import com.bisket.engine.repository.SafetyOfficinalSaleRepository;
import com.bisket.engine.domain.SafetyOfficinalSale;
import com.bisket.engine.parser.SafetyOffinialSaleParser;
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
import java.util.List;
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
        List<SafetyOfficinalSale> safetyOfficinalSaleList = SafetyOffinialSaleParser.getSafetyOffinialSaleListFromXml(xml);

        if (!safetyOfficinalSaleList.isEmpty()) {
            for (int i = 0; i < safetyOfficinalSaleList.size(); i++) {
                SafetyOfficinalSale safetyOfficinalSale = safetyOfficinalSaleList.get(i);
                log.info("=======\nSafetyOfficinalSale\nSequence: {}\nManagementCode: {}", i+1, safetyOfficinalSale.getManagementCode());
                SafetyOfficinalSale foundSafetyOfficinalSale =
                        safetyOfficinalSaleRepository.findOneByManagementCode(safetyOfficinalSale.getManagementCode());
                if (foundSafetyOfficinalSale != null) {
                    /* 업데이트 진행 */
                    safetyOfficinalSale.getAndSetIdentification(foundSafetyOfficinalSale);
                    if (!Objects.equals(foundSafetyOfficinalSale, safetyOfficinalSale)) {
                        foundSafetyOfficinalSale.update(safetyOfficinalSale);
                    }
                } else {
                    /* 인서트 진행 */
                    safetyOfficinalSaleRepository.save(safetyOfficinalSale);
                }
            }
        }

        return safetyOfficinalSaleList.size();
    }
}

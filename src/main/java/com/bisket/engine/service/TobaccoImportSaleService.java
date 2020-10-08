package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.TobaccoImportSale;
import com.bisket.engine.parser.TobaccoImportSaleParser;
import com.bisket.engine.repository.TobaccoImportSaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@Slf4j
public class TobaccoImportSaleService implements BusinessBaseService {
    private final TobaccoImportSaleRepository tobaccoImportSaleRepository;

    public TobaccoImportSaleService(TobaccoImportSaleRepository tobaccoImportSaleRepository) {
        this.tobaccoImportSaleRepository = tobaccoImportSaleRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<TobaccoImportSale> parsedList = TobaccoImportSaleParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, TobaccoImportSale> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<TobaccoImportSale> foundList = tobaccoImportSaleRepository.findAll();
            if (!foundList.isEmpty()) {
                for (TobaccoImportSale found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                TobaccoImportSale parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    TobaccoImportSale found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    tobaccoImportSaleRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

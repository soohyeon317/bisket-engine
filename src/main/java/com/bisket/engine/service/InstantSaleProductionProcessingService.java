package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.InstantSaleProductionProcessing;
import com.bisket.engine.parser.InstantSaleProductionProcessingParser;
import com.bisket.engine.repository.InstantSaleProductionProcessingRepository;
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
public class InstantSaleProductionProcessingService implements BusinessBaseService {
    private final InstantSaleProductionProcessingRepository instantSaleProductionProcessingRepository;

    public InstantSaleProductionProcessingService(InstantSaleProductionProcessingRepository instantSaleProductionProcessingRepository) {
        this.instantSaleProductionProcessingRepository = instantSaleProductionProcessingRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<InstantSaleProductionProcessing> parsedList = InstantSaleProductionProcessingParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, InstantSaleProductionProcessing> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<InstantSaleProductionProcessing> foundList = instantSaleProductionProcessingRepository.findAll();
            if (!foundList.isEmpty()) {
                for (InstantSaleProductionProcessing found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                InstantSaleProductionProcessing parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    InstantSaleProductionProcessing found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    instantSaleProductionProcessingRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

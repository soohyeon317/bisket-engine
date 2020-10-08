package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.InstantSaleManufacturingProcessing;
import com.bisket.engine.parser.InstantSaleManufacturingProcessingParser;
import com.bisket.engine.repository.InstantSaleManufacturingProcessingRepository;
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
public class InstantSaleManufacturingProcessingService implements BusinessBaseService {
    private final InstantSaleManufacturingProcessingRepository instantSaleManufacturingProcessingRepository;

    public InstantSaleManufacturingProcessingService(InstantSaleManufacturingProcessingRepository instantSaleManufacturingProcessingRepository) {
        this.instantSaleManufacturingProcessingRepository = instantSaleManufacturingProcessingRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<InstantSaleManufacturingProcessing> parsedList = InstantSaleManufacturingProcessingParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, InstantSaleManufacturingProcessing> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<InstantSaleManufacturingProcessing> foundList = instantSaleManufacturingProcessingRepository.findAll();
            if (!foundList.isEmpty()) {
                for (InstantSaleManufacturingProcessing found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                InstantSaleManufacturingProcessing parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    InstantSaleManufacturingProcessing found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    instantSaleManufacturingProcessingRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

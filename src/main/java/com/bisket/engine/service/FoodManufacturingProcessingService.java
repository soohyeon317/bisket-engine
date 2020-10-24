package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.entity.FoodManufacturingProcessing;
import com.bisket.engine.parser.FoodManufacturingProcessingParser;
import com.bisket.engine.repository.FoodManufacturingProcessingRepository;
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
public class FoodManufacturingProcessingService implements BusinessBaseService {
    private final FoodManufacturingProcessingRepository foodManufacturingProcessingRepository;

    public FoodManufacturingProcessingService(FoodManufacturingProcessingRepository foodManufacturingProcessingRepository) {
        this.foodManufacturingProcessingRepository = foodManufacturingProcessingRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<FoodManufacturingProcessing> parsedList = FoodManufacturingProcessingParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, FoodManufacturingProcessing> compositeKeyToFoundObjectMap = new HashMap<>();
            List<FoodManufacturingProcessing> foundList = foodManufacturingProcessingRepository.findAll();
            if (!foundList.isEmpty()) {
                for (FoodManufacturingProcessing found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeKeyToFoundObjectMap.put(compositeKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                FoodManufacturingProcessing parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeKeyToFoundObjectMap.containsKey(compositeKey)) {
                    /* 업데이트 진행 */
                    FoodManufacturingProcessing found = compositeKeyToFoundObjectMap.get(compositeKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    foodManufacturingProcessingRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

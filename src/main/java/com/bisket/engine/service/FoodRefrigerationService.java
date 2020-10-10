package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.FoodRefrigeration;
import com.bisket.engine.parser.FoodRefrigerationParser;
import com.bisket.engine.repository.FoodRefrigerationRepository;
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
public class FoodRefrigerationService implements BusinessBaseService {
    private final FoodRefrigerationRepository foodRefrigerationRepository;

    public FoodRefrigerationService(FoodRefrigerationRepository foodRefrigerationRepository) {
        this.foodRefrigerationRepository = foodRefrigerationRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<FoodRefrigeration> parsedList = FoodRefrigerationParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, FoodRefrigeration> compositeKeyToFoundObjectMap = new HashMap<>();
            List<FoodRefrigeration> foundList = foodRefrigerationRepository.findAll();
            if (!foundList.isEmpty()) {
                for (FoodRefrigeration found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeKeyToFoundObjectMap.put(compositeKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                FoodRefrigeration parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeKeyToFoundObjectMap.containsKey(compositeKey)) {
                    /* 업데이트 진행 */
                    FoodRefrigeration found = compositeKeyToFoundObjectMap.get(compositeKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    foodRefrigerationRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.InternationalConferenceFacility;
import com.bisket.engine.parser.InternationalConferenceFacilityParser;
import com.bisket.engine.repository.InternationalConferenceFacilityRepository;
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
public class InternationalConferenceFacilityService implements BusinessBaseService {
    private final InternationalConferenceFacilityRepository internationalConferenceFacilityRepository;

    public InternationalConferenceFacilityService(InternationalConferenceFacilityRepository internationalConferenceFacilityRepository) {
        this.internationalConferenceFacilityRepository = internationalConferenceFacilityRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<InternationalConferenceFacility> parsedList = InternationalConferenceFacilityParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, InternationalConferenceFacility> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<InternationalConferenceFacility> foundList = internationalConferenceFacilityRepository.findAll();
            if (!foundList.isEmpty()) {
                for (InternationalConferenceFacility found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                InternationalConferenceFacility parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    InternationalConferenceFacility found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    internationalConferenceFacilityRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}
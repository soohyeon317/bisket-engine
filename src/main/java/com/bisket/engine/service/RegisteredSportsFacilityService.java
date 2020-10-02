package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.RegisteredSportsFacility;
import com.bisket.engine.parser.RegisteredSportsFacilityParser;
import com.bisket.engine.repository.RegisteredSportsFacilityRepository;
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
public class RegisteredSportsFacilityService implements BusinessBaseService {
    private final RegisteredSportsFacilityRepository registeredSportsFacilityRepository;

    public RegisteredSportsFacilityService(RegisteredSportsFacilityRepository registeredSportsFacilityRepository) {
        this.registeredSportsFacilityRepository = registeredSportsFacilityRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<RegisteredSportsFacility> parsedList = RegisteredSportsFacilityParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, RegisteredSportsFacility> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<RegisteredSportsFacility> foundList = registeredSportsFacilityRepository.findAll();
            if (!foundList.isEmpty()) {
                for (RegisteredSportsFacility found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                RegisteredSportsFacility parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    RegisteredSportsFacility found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    registeredSportsFacilityRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

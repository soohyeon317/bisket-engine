package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.BuildingSanitation;
import com.bisket.engine.parser.BuildingSanitationParser;
import com.bisket.engine.repository.BuildingSanitationRepository;
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
public class BuildingSanitationService implements BusinessBaseService {
    private final BuildingSanitationRepository buildingSanitationRepository;

    public BuildingSanitationService(BuildingSanitationRepository buildingSanitationRepository) {
        this.buildingSanitationRepository = buildingSanitationRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<BuildingSanitation> parsedList = BuildingSanitationParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, BuildingSanitation> compositeKeyToFoundObjectMap = new HashMap<>();
            List<BuildingSanitation> foundList = buildingSanitationRepository.findAll();
            if (!foundList.isEmpty()) {
                for (BuildingSanitation found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeKeyToFoundObjectMap.put(compositeKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                BuildingSanitation parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeKey = Commons.getCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeKeyToFoundObjectMap.containsKey(compositeKey)) {
                    /* 업데이트 진행 */
                    BuildingSanitation found = compositeKeyToFoundObjectMap.get(compositeKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    buildingSanitationRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

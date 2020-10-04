package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.LivestockProductTransport;
import com.bisket.engine.parser.LivestockProductTransportParser;
import com.bisket.engine.repository.LivestockProductTransportRepository;
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
public class LivestockProductTransportService implements BusinessBaseService {
    private final LivestockProductTransportRepository livestockProductTransportRepository;

    public LivestockProductTransportService(LivestockProductTransportRepository livestockProductTransportRepository) {
        this.livestockProductTransportRepository = livestockProductTransportRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<LivestockProductTransport> parsedList = LivestockProductTransportParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, LivestockProductTransport> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<LivestockProductTransport> foundList = livestockProductTransportRepository.findAll();
            if (!foundList.isEmpty()) {
                for (LivestockProductTransport found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                LivestockProductTransport parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    LivestockProductTransport found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    livestockProductTransportRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}
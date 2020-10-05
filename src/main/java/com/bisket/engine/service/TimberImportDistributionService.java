package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.TimberImportDistribution;
import com.bisket.engine.parser.TimberImportDistributionParser;
import com.bisket.engine.repository.TimberImportDistributionRepository;
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
public class TimberImportDistributionService implements BusinessBaseService {
    private final TimberImportDistributionRepository timberImportDistributionRepository;

    public TimberImportDistributionService(TimberImportDistributionRepository timberImportDistributionRepository) {
        this.timberImportDistributionRepository = timberImportDistributionRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<TimberImportDistribution> parsedList = TimberImportDistributionParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, TimberImportDistribution> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<TimberImportDistribution> foundList = timberImportDistributionRepository.findAll();
            if (!foundList.isEmpty()) {
                for (TimberImportDistribution found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                TimberImportDistribution parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    TimberImportDistribution found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    timberImportDistributionRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

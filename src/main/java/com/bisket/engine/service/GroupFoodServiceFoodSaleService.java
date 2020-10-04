package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.domain.GroupFoodServiceFoodSale;
import com.bisket.engine.parser.GroupFoodServiceFoodSaleParser;
import com.bisket.engine.repository.GroupFoodServiceFoodSaleRepository;
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
public class GroupFoodServiceFoodSaleService implements BusinessBaseService {
    private final GroupFoodServiceFoodSaleRepository groupFoodServiceFoodSaleRepository;

    public GroupFoodServiceFoodSaleService(GroupFoodServiceFoodSaleRepository groupFoodServiceFoodSaleRepository) {
        this.groupFoodServiceFoodSaleRepository = groupFoodServiceFoodSaleRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<GroupFoodServiceFoodSale> parsedList = GroupFoodServiceFoodSaleParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, GroupFoodServiceFoodSale> compositeUniqueKeyToFoundObjectMap = new HashMap<>();
            List<GroupFoodServiceFoodSale> foundList = groupFoodServiceFoodSaleRepository.findAll();
            if (!foundList.isEmpty()) {
                for (GroupFoodServiceFoodSale found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeUniqueKeyToFoundObjectMap.put(compositeUniqueKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                GroupFoodServiceFoodSale parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeUniqueKey = Commons.getCompositeUniqueKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeUniqueKeyToFoundObjectMap.containsKey(compositeUniqueKey)) {
                    /* 업데이트 진행 */
                    GroupFoodServiceFoodSale found = compositeUniqueKeyToFoundObjectMap.get(compositeUniqueKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    groupFoodServiceFoodSaleRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}
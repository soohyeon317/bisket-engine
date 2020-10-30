package com.bisket.engine.service;

import com.bisket.engine.common.Commons;
import com.bisket.engine.entity.MedicalDeviceRepair;
import com.bisket.engine.parser.MedicalDeviceRepairParser;
import com.bisket.engine.repository.MedicalDeviceRepairRepository;
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
public class MedicalDeviceRepairService implements BusinessBaseService {
    private final MedicalDeviceRepairRepository medicalDeviceRepairRepository;

    public MedicalDeviceRepairService(MedicalDeviceRepairRepository medicalDeviceRepairRepository) {
        this.medicalDeviceRepairRepository = medicalDeviceRepairRepository;
    }

    @Override
    @Transactional
    public Integer updateListFromXmlFile(String filePath) throws Exception {
        FileReader fileReader = new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8));
        InputSource inputSource = new InputSource(fileReader);
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        List<MedicalDeviceRepair> parsedList = MedicalDeviceRepairParser.getListFromXml(xml);

        if (!parsedList.isEmpty()) {
            Map<String, MedicalDeviceRepair> compositeKeyToFoundObjectMap = new HashMap<>();
            List<MedicalDeviceRepair> foundList = medicalDeviceRepairRepository.findAll();
            if (!foundList.isEmpty()) {
                for (MedicalDeviceRepair found : foundList) {
                    String openServiceId = found.getOpenServiceId();
                    String openAutonomousBodyCode = found.getOpenAutonomousBodyCode();
                    String managementCode = found.getManagementCode();
                    String compositeKey = Commons.getBusinessCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                    compositeKeyToFoundObjectMap.put(compositeKey, found);
                }
            }
            for (int i = 0; i < parsedList.size(); i++) {
                MedicalDeviceRepair parsed = parsedList.get(i);
                String openServiceId = parsed.getOpenServiceId();
                String openAutonomousBodyCode = parsed.getOpenAutonomousBodyCode();
                String managementCode = parsed.getManagementCode();
                String compositeKey = Commons.getBusinessCompositeKey(openServiceId, openAutonomousBodyCode, managementCode);
                log.info("=======\nSequence: {}\nopenServiceId={}\nopenAutonomousBodyCode={}\nmanagementCode={}",
                        i+1, openServiceId, openAutonomousBodyCode, managementCode);
                if (compositeKeyToFoundObjectMap.containsKey(compositeKey)) {
                    /* 업데이트 진행 */
                    MedicalDeviceRepair found = compositeKeyToFoundObjectMap.get(compositeKey);
                    parsed.getAndSetIdentification(found);
                    if (!Objects.equals(found, parsed)) {
                        found.update(parsed);
                    }
                } else {
                    /* 인서트 진행 */
                    medicalDeviceRepairRepository.save(parsed);
                }
            }
        }

        return parsedList.size();
    }
}

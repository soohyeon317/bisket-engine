package com.bisket.engine.service;

import com.bisket.engine.repository.BusinessUpdateHistoryRepository;
import com.bisket.engine.domain.BusinessUpdateHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BusinessUpdateHistoryService {
    private BusinessUpdateHistoryRepository businessUpdateHistoryRepository;

    public BusinessUpdateHistoryService(BusinessUpdateHistoryRepository businessUpdateHistoryRepository) {
        this.businessUpdateHistoryRepository = businessUpdateHistoryRepository;
    }

    @Transactional
    public BusinessUpdateHistory createOne(BusinessUpdateHistory businessUpdateHistory) {
        return businessUpdateHistoryRepository.save(businessUpdateHistory);
    }
}

package com.bisket.engine.repository;

import com.bisket.engine.domain.BusinessUpdateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessUpdateHistoryRepository extends JpaRepository<BusinessUpdateHistory, Long> {
}

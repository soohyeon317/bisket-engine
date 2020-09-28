package com.bisket.engine.repository;

import com.bisket.engine.domain.SafetyOfficinalSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafetyOfficinalSaleRepository extends JpaRepository<SafetyOfficinalSale, Long> {
    SafetyOfficinalSale findOneByManagementCode(String managementCode);
}

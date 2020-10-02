package com.bisket.engine.repository;

import com.bisket.engine.domain.PotteryProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotteryProductionRepository extends JpaRepository<PotteryProduction, Long> {
}

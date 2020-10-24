package com.bisket.engine.repository;

import com.bisket.engine.entity.GameProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameProductionRepository extends JpaRepository<GameProduction, Long> {
}

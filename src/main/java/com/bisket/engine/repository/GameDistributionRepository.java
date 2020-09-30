package com.bisket.engine.repository;

import com.bisket.engine.domain.GameDistribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDistributionRepository extends JpaRepository<GameDistribution, Long> {
}

package com.bisket.engine.repository;

import com.bisket.engine.domain.VideoDistribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDistributionRepository extends JpaRepository<VideoDistribution, Long> {
}

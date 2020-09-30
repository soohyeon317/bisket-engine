package com.bisket.engine.repository;

import com.bisket.engine.domain.VideoProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoProductionRepository extends JpaRepository<VideoProduction, Long> {
}

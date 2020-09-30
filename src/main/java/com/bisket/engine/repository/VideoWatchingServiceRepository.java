package com.bisket.engine.repository;

import com.bisket.engine.domain.VideoWatchingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoWatchingServiceRepository extends JpaRepository<VideoWatchingService, Long> {
}

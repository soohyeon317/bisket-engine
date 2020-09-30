package com.bisket.engine.repository;

import com.bisket.engine.domain.OnlineMusicService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineMusicServiceRepository extends JpaRepository<OnlineMusicService, Long> {
}

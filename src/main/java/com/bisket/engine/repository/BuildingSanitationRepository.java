package com.bisket.engine.repository;

import com.bisket.engine.domain.BuildingSanitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingSanitationRepository extends JpaRepository<BuildingSanitation, Long> {
}
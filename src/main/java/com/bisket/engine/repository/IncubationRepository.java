package com.bisket.engine.repository;

import com.bisket.engine.domain.Incubation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncubationRepository extends JpaRepository<Incubation, Long> {
}
package com.bisket.engine.repository;

import com.bisket.engine.domain.Lumbering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LumberingRepository extends JpaRepository<Lumbering, Long> {
}
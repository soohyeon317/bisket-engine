package com.bisket.engine.repository;

import com.bisket.engine.domain.MovieProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieProductionRepository extends JpaRepository<MovieProduction, Long> {
}

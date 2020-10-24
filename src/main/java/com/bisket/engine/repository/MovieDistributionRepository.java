package com.bisket.engine.repository;

import com.bisket.engine.entity.MovieDistribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDistributionRepository extends JpaRepository<MovieDistribution, Long> {
}

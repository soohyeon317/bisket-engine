package com.bisket.engine.repository;

import com.bisket.engine.domain.MovieScreening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieScreeningRepository extends JpaRepository<MovieScreening, Long> {
}

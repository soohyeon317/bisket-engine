package com.bisket.engine.repository;

import com.bisket.engine.domain.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long> {
}

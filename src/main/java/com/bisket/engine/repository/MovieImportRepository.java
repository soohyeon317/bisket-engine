package com.bisket.engine.repository;

import com.bisket.engine.domain.MovieImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImportRepository extends JpaRepository<MovieImport, Long> {
}

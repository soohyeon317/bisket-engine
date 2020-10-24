package com.bisket.engine.repository;

import com.bisket.engine.entity.MovieImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImportRepository extends JpaRepository<MovieImport, Long> {
}

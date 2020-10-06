package com.bisket.engine.repository;

import com.bisket.engine.domain.Disinfection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisinfectionRepository extends JpaRepository<Disinfection, Long> {
}

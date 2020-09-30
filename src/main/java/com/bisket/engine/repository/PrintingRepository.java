package com.bisket.engine.repository;

import com.bisket.engine.domain.Printing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingRepository extends JpaRepository<Printing, Long> {
}

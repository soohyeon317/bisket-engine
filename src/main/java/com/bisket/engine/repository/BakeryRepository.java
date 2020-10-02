package com.bisket.engine.repository;

import com.bisket.engine.domain.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BakeryRepository extends JpaRepository<Bakery, Long> {
}

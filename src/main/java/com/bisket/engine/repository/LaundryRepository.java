package com.bisket.engine.repository;

import com.bisket.engine.domain.Laundry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundryRepository extends JpaRepository<Laundry, Long> {
}

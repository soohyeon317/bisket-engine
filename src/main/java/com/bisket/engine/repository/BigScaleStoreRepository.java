package com.bisket.engine.repository;

import com.bisket.engine.domain.BigScaleStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BigScaleStoreRepository extends JpaRepository<BigScaleStore, Long> {
}
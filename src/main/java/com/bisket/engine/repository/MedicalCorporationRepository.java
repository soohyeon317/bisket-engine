package com.bisket.engine.repository;

import com.bisket.engine.domain.MedicalCorporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCorporationRepository extends JpaRepository<MedicalCorporation, Long> {
}

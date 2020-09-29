package com.bisket.engine.repository;

import com.bisket.engine.domain.EmergencyPatientTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyPatientTransferRepository extends JpaRepository<EmergencyPatientTransfer, Long> {
}

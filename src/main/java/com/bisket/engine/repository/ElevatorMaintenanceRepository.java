package com.bisket.engine.repository;

import com.bisket.engine.domain.ElevatorMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorMaintenanceRepository extends JpaRepository<ElevatorMaintenance, Long> {
}

package com.bisket.engine.repository;

import com.bisket.engine.domain.FoodVendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodVendingMachineRepository extends JpaRepository<FoodVendingMachine, Long> {
}

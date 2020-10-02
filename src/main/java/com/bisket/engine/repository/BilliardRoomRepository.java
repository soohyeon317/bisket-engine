package com.bisket.engine.repository;

import com.bisket.engine.domain.BilliardRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilliardRoomRepository extends JpaRepository<BilliardRoom, Long> {
}

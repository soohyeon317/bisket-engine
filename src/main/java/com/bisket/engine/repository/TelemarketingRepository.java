package com.bisket.engine.repository;

import com.bisket.engine.domain.Telemarketing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemarketingRepository extends JpaRepository<Telemarketing, Long> {
}

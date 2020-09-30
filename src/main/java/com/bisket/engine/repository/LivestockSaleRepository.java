package com.bisket.engine.repository;

import com.bisket.engine.domain.LivestockSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivestockSaleRepository extends JpaRepository<LivestockSale, Long> {
}

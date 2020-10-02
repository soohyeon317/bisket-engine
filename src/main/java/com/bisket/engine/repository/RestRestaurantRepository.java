package com.bisket.engine.repository;

import com.bisket.engine.domain.RestRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestRestaurantRepository extends JpaRepository<RestRestaurant, Long> {
}

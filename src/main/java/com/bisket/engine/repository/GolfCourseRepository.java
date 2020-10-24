package com.bisket.engine.repository;

import com.bisket.engine.entity.GolfCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GolfCourseRepository extends JpaRepository<GolfCourse, Long> {
}

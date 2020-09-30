package com.bisket.engine.repository;

import com.bisket.engine.domain.VideoRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRoomRepository extends JpaRepository<VideoRoom, Long> {
}

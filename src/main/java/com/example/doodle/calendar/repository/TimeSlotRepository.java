package com.example.doodle.calendar.repository;

import com.example.doodle.calendar.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface TimeSlotRepository
        extends JpaRepository<TimeSlot, UUID> {

    List<TimeSlot> findByUserIdAndStartTimeBetween(
            UUID userId, Instant from, Instant to
    );
}

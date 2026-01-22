package com.example.doodle.slot;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, UUID> {
}

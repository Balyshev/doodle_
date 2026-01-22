package com.example.doodle.calendar.service;

import com.example.doodle.calendar.*;
import com.example.doodle.calendar.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class TimeSlotService {

    private final TimeSlotRepository slots;
    private final UserRepository users;

    public TimeSlotService(TimeSlotRepository slots, UserRepository users) {
        this.slots = slots;
        this.users = users;
    }

    public UUID create(UUID userId, Instant start, Duration duration) {
        User user = users.findById(userId).orElseThrow();

        TimeSlot slot = new TimeSlot();
        slot.setUser(user);
        slot.setStartTime(start);
        slot.setEndTime(start.plus(duration));
        slot.setStatus(SlotStatus.FREE);

        return slots.save(slot).getId();
    }
}

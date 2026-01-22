package com.example.doodle.calendar;

import java.time.Instant;
import java.util.List;

public class Calendar {

    private final List<TimeSlot> slots;

    public Calendar(List<TimeSlot> slots) {
        this.slots = slots;
    }

    public List<TimeSlot> free(Instant from, Instant to) {
        return slots.stream()
                .filter(s -> s.getStatus() == SlotStatus.FREE)
                .filter(s -> !s.getStartTime().isAfter(to))
                .filter(s -> !s.getEndTime().isBefore(from))
                .toList();
    }

    public List<TimeSlot> busy(Instant from, Instant to) {
        return slots.stream()
                .filter(s -> s.getStatus() != SlotStatus.FREE)
                .filter(s -> !s.getStartTime().isAfter(to))
                .filter(s -> !s.getEndTime().isBefore(from))
                .toList();
    }
}

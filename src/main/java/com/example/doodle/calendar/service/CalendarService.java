package com.example.doodle.calendar.service;

import com.example.doodle.calendar.*;
import com.example.doodle.calendar.repository.*;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CalendarService {

    private final TimeSlotRepository slots;

    public CalendarService(TimeSlotRepository slots) {
        this.slots = slots;
    }

    public Map<String, List<TimeSlot>> availability(
            UUID userId, Instant from, Instant to
    ) {
        List<TimeSlot> list =
                slots.findByUserIdAndStartTimeBetween(userId, from, to);

        Calendar calendar = new Calendar(list);

        return Map.of(
                "free", calendar.free(from, to),
                "busy", calendar.busy(from, to)
        );
    }
}

package com.example.doodle.calendar.api;

import com.example.doodle.calendar.TimeSlot;
import com.example.doodle.calendar.service.CalendarService;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService service;

    public CalendarController(CalendarService service) {
        this.service = service;
    }

    @GetMapping("/{userId}/availability")
    public Map<String, List<TimeSlot>> availability(
            @PathVariable("userId") UUID userId,
            @RequestParam("from") String from,
            @RequestParam("to") String to
    ) {
        Instant fromTime = Instant.parse(from);
        Instant toTime = Instant.parse(to);

        return service.availability(userId, fromTime, toTime);
    }
}

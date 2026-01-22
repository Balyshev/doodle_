package com.example.doodle.calendar.api;

import com.example.doodle.calendar.service.TimeSlotService;
import org.springframework.web.bind.annotation.*;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.time.Instant;
import java.time.Duration;



@RestController
@RequestMapping("/api/slots")
public class TimeSlotController {

    private final TimeSlotService service;

    public TimeSlotController(TimeSlotService service) {
        this.service = service;
    }

    @PostMapping
    public UUID create(
            @RequestParam("userId") UUID userId,
            @RequestParam("startTime") String startTime,
            @RequestParam("durationMinutes") long durationMinutes
    ) {
        Instant parsedStartTime = Instant.parse(startTime);

        return service.create(
                userId,
                parsedStartTime,
                Duration.ofMinutes(durationMinutes)
        );
    }
}

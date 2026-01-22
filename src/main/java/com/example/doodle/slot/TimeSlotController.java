package com.example.doodle.slot;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/slots")
public class TimeSlotController {

    private final TimeSlotRepository repository;

    public TimeSlotController(TimeSlotRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TimeSlot create(@RequestBody TimeSlot slot) {
        return repository.save(slot);
    }

    @GetMapping
    public List<TimeSlot> all() {
        return repository.findAll();
    }
}

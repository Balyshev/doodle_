package com.example.doodle.calendar.api;

import com.example.doodle.calendar.*;
import com.example.doodle.calendar.repository.*;
import com.example.doodle.calendar.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Arrays;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService service;
    private final UserRepository users;

    public MeetingController(MeetingService service, UserRepository users) {
        this.service = service;
        this.users = users;
    }

    @PostMapping
    public UUID book(
            @RequestParam("slotId") UUID slotId,
            @RequestParam("title") String title,
            @RequestParam("participantIds") String participantIds
    ) {
        Set<User> participants = Arrays.stream(participantIds.split(","))
                .map(UUID::fromString)
                .map(id -> users.findById(id).orElseThrow())
                .collect(Collectors.toSet());

        return service.book(slotId, title, participants);
    }
}

package com.example.doodle.meeting;

import com.example.doodle.slot.SlotStatus;
import com.example.doodle.slot.TimeSlotRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingRepository meetingRepository;
    private final TimeSlotRepository slotRepository;

    public MeetingController(MeetingRepository meetingRepository,
                             TimeSlotRepository slotRepository) {
        this.meetingRepository = meetingRepository;
        this.slotRepository = slotRepository;
    }

    @PostMapping
    public Meeting create(@RequestBody Meeting meeting) {
        meeting.getSlot().setStatus(SlotStatus.BUSY);
        slotRepository.save(meeting.getSlot());
        return meetingRepository.save(meeting);
    }
}

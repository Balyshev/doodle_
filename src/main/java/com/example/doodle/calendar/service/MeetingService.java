package com.example.doodle.calendar.service;

import com.example.doodle.calendar.*;
import com.example.doodle.calendar.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class MeetingService {

    private final TimeSlotRepository slots;
    private final MeetingRepository meetings;

    public MeetingService(TimeSlotRepository slots, MeetingRepository meetings) {
        this.slots = slots;
        this.meetings = meetings;
    }

    public UUID book(UUID slotId, String title, Set<User> participants) {
        TimeSlot slot = slots.findById(slotId).orElseThrow();
        if (slot.getStatus() != SlotStatus.FREE)
            throw new IllegalStateException("Slot busy");

        slot.setStatus(SlotStatus.MEETING);

        Meeting meeting = new Meeting();
        meeting.setTitle(title);
        meeting.setSlot(slot);
        meeting.setParticipants(participants);

        return meetings.save(meeting).getId();
    }
}

package com.example.doodle.slot;

import com.example.doodle.calendar.Calendar;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private SlotStatus status = SlotStatus.FREE;

    @ManyToOne
    private Calendar calendar;

    public UUID getId() { return id; }
    public SlotStatus getStatus() { return status; }
    public void setStatus(SlotStatus status) { this.status = status; }
}

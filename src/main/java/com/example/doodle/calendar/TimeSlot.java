package com.example.doodle.calendar;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "time_slots")
public class TimeSlot {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private User user;

    private Instant startTime;
    private Instant endTime;

    @Enumerated(EnumType.STRING)
    private SlotStatus status;

    public TimeSlot() {}

    public UUID getId() { return id; }
    public User getUser() { return user; }
    public Instant getStartTime() { return startTime; }
    public Instant getEndTime() { return endTime; }
    public SlotStatus getStatus() { return status; }

    public void setUser(User user) { this.user = user; }
    public void setStartTime(Instant startTime) { this.startTime = startTime; }
    public void setEndTime(Instant endTime) { this.endTime = endTime; }
    public void setStatus(SlotStatus status) { this.status = status; }
}

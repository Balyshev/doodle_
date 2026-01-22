package com.example.doodle.calendar;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "meetings")
public class Meeting {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    @OneToOne
    private TimeSlot slot;

    @ManyToMany
    private Set<User> participants;

    public Meeting() {}

    public void setTitle(String title) { this.title = title; }
    public void setSlot(TimeSlot slot) { this.slot = slot; }
    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public UUID getId() { return id; }
}

package com.example.doodle.meeting;

import com.example.doodle.slot.TimeSlot;
import com.example.doodle.user.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;

    @OneToOne
    private TimeSlot slot;

    @ManyToMany
    private List<User> participants;

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

}



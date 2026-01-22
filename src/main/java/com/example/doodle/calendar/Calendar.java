package com.example.doodle.calendar;

import com.example.doodle.user.User;
import jakarta.persistence.*;

@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User owner;
}

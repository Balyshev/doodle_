package com.example.doodle.calendar;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    protected User() {}

    public User(String email) {
        this.email = email;
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
}

package com.example.doodle.calendar.repository;

import com.example.doodle.calendar.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {}

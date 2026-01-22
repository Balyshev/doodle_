package com.example.doodle.calendar.repository;

import com.example.doodle.calendar.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {}

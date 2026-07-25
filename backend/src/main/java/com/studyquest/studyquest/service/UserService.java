package com.studyquest.studyquest.service;

import com.studyquest.studyquest.entity.User;
import com.studyquest.studyquest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }

        user.setXp(0);
        user.setLevel(1);
        user.setStreak(0);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

}
package com.example.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userservice.User;
import com.example.userservice.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
package com.example.tofolla.service;

import com.example.tofolla.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    Boolean hasUserWithEmail(String email);

    User login(User user);

    User getUser(Long userId);

    User updateUser(Long userId, User user);

    List<User> getAllUsers(); // Add this line

}

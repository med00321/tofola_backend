package com.example.tofolla.controller;

import com.example.tofolla.entity.User;
import com.example.tofolla.entity.minor;
import com.example.tofolla.enums.UserRole;
import com.example.tofolla.service.MinorService;
import com.example.tofolla.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private MinorService minorService;
    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody @Valid User user) {

        if (userService.hasUserWithEmail(user.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        User createdUser = userService.createUser(user);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created, try again later", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User dbUser = userService.login(user);
        if (dbUser == null) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(dbUser, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id, @RequestParam Long loggedInUserId) {
        User loggedInUser = userService.getUser(loggedInUserId);
        if (loggedInUser == null) {
            return new ResponseEntity<>("Logged in user not found", HttpStatus.NOT_FOUND);
        }

        // Allow admin to access any user's data
        if (loggedInUser.getRole() == UserRole.ADMIN || loggedInUser.getId().equals(id)) {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user, @RequestParam Long loggedInUserId) {
        User loggedInUser = userService.getUser(loggedInUserId);
        if (loggedInUser == null) {
            return new ResponseEntity<>("Logged in user not found", HttpStatus.NOT_FOUND);
        }

        // Allow admin to update any user's data
        if (loggedInUser.getRole() == UserRole.ADMIN || loggedInUser.getId().equals(id)) {
            return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/users/{userId}/minors")
    public ResponseEntity<List<minor>> getMinorsByUserId(@PathVariable Long userId) {
        List<minor> minors = minorService.getMinorsByUserId(userId);
        if (minors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(minors, HttpStatus.OK);
    }
}

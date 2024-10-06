package com.example.tofolla.service;

import com.example.tofolla.entity.User;
import com.example.tofolla.enums.UserRole;
import com.example.tofolla.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser() {
        User adminUser = userRepository.findByRole(UserRole.ADMIN);
        if (adminUser == null) {
            User user = new User("admin@gmail.com", "admin", "Admin", UserRole.ADMIN);
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public User createUser(User user) {
        user.setRole(UserRole.USER);
        user.setPassword(user.getPassword()); // Ideally, hash the password here
        return userRepository.save(user);
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    @Override
    public User login(User user) {
        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());
        return dbUser.filter(value -> user.getPassword().equals(value.getPassword())).orElse(null);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            savedUser.setEmail(user.getEmail());
            return userRepository.save(savedUser);
        }
        return null;
    }
}

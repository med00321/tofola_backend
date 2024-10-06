package com.example.tofolla.repository;

import com.example.tofolla.entity.User;
import com.example.tofolla.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findFirstByEmail(String email);

    User findByRole(UserRole role);

    Optional<User> findByEmail(String email);
}

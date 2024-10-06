package com.example.tofolla.repository;

import com.example.tofolla.entity.minor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinorRepository extends JpaRepository<minor, Long> {
    List<minor> findByUserId(Long userId);
}

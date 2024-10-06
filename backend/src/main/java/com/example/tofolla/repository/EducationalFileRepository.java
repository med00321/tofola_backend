package com.example.tofolla.repository;

import com.example.tofolla.entity.EducationalFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationalFileRepository extends JpaRepository<EducationalFile, Long> {
    void deleteByMinorId(Long id);
}

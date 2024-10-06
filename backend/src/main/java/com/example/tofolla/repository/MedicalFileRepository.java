package com.example.tofolla.repository;

import com.example.tofolla.entity.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalFileRepository extends JpaRepository<MedicalFile, Long> {
    void deleteByMinorId(Long id);
}

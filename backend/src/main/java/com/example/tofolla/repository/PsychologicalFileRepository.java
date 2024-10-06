package com.example.tofolla.repository;

import com.example.tofolla.entity.PsychologicalFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologicalFileRepository extends JpaRepository<PsychologicalFile, Long> {
    void deleteByMinorId(Long id);
}

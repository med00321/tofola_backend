package com.example.tofolla.repository;

import com.example.tofolla.entity.LegalFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalFileRepository extends JpaRepository<LegalFile, Long> {
    void deleteByMinorId(Long id);
}

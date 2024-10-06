package com.example.tofolla.repository;

import com.example.tofolla.entity.HistoricalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalRecordRepository extends JpaRepository<HistoricalRecord, Long> {
}

package com.example.tofolla.service;

import com.example.tofolla.entity.HistoricalRecord;
import com.example.tofolla.entity.minor;
import com.example.tofolla.repository.HistoricalRecordRepository;
import com.example.tofolla.repository.MinorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalRecordService {

    @Autowired
    private HistoricalRecordRepository historicalRecordRepository;

    @Autowired
    private MinorRepository minorRepository;

    public List<HistoricalRecord> getAllHistoricalRecords() {
        return historicalRecordRepository.findAll();
    }

    public Optional<HistoricalRecord> getHistoricalRecordById(Long id) {
        return historicalRecordRepository.findById(id);
    }

    public HistoricalRecord addHistoricalRecord(HistoricalRecord historicalRecord) {
        // Fetch Minor entity from the database
        minor minor = minorRepository.findById(historicalRecord.getminor().getId())
                .orElseThrow(() -> new RuntimeException("Minor not found with id " + historicalRecord.getminor().getId()));

        historicalRecord.setminor(minor);
        return historicalRecordRepository.save(historicalRecord);
    }

    public HistoricalRecord updateHistoricalRecord(Long id, HistoricalRecord historicalRecordDetails) {
        HistoricalRecord historicalRecord = historicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HistoricalRecord not found with id " + id));

        // Update fields except id
        historicalRecord.setEventDetails(historicalRecordDetails.getEventDetails());
        historicalRecord.setTimestamp(historicalRecordDetails.getTimestamp());

        // Fetch and set Minor entity
        minor minor = minorRepository.findById(historicalRecordDetails.getminor().getId())
                .orElseThrow(() -> new RuntimeException("Minor not found with id " + historicalRecordDetails.getminor().getId()));
        historicalRecord.setminor(minor);

        return historicalRecordRepository.save(historicalRecord);
    }

    public void deleteHistoricalRecord(Long id) {
        historicalRecordRepository.deleteById(id);
    }
}

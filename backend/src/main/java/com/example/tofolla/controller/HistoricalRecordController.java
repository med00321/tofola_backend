package com.example.tofolla.controller;

import com.example.tofolla.entity.HistoricalRecord;
import com.example.tofolla.service.HistoricalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historical-records")
public class HistoricalRecordController {

    @Autowired
    private HistoricalRecordService historicalRecordService;

    @GetMapping
    public ResponseEntity<List<HistoricalRecord>> getAllHistoricalRecords() {
        List<HistoricalRecord> records = historicalRecordService.getAllHistoricalRecords();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricalRecord> getHistoricalRecordById(@PathVariable Long id) {
        Optional<HistoricalRecord> historicalRecord = historicalRecordService.getHistoricalRecordById(id);
        return historicalRecord.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistoricalRecord> addHistoricalRecord(@RequestBody HistoricalRecord historicalRecord) {
        try {
            HistoricalRecord savedRecord = historicalRecordService.addHistoricalRecord(historicalRecord);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricalRecord> updateHistoricalRecord(@PathVariable Long id, @RequestBody HistoricalRecord historicalRecordDetails) {
        try {
            HistoricalRecord updatedRecord = historicalRecordService.updateHistoricalRecord(id, historicalRecordDetails);
            return ResponseEntity.ok(updatedRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoricalRecord(@PathVariable Long id) {
        try {
            historicalRecordService.deleteHistoricalRecord(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

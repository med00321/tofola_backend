package com.example.tofolla.controller;

import com.example.tofolla.entity.MedicalFile;
import com.example.tofolla.service.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-files")
public class MedicalFileController {

    @Autowired
    private MedicalFileService medicalFileService;

    @GetMapping
    public List<MedicalFile> getAllMedicalFiles() {
        return medicalFileService.getAllMedicalFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalFile> getMedicalFileById(@PathVariable Long id) {
        Optional<MedicalFile> medicalFile = medicalFileService.getMedicalFileById(id);
        return medicalFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MedicalFile addMedicalFile(@RequestBody MedicalFile medicalFile) {
        return medicalFileService.addMedicalFile(medicalFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalFile> updateMedicalFile(@PathVariable Long id, @RequestBody MedicalFile medicalFileDetails) {
        MedicalFile updatedMedicalFile = medicalFileService.updateMedicalFile(id, medicalFileDetails);
        return ResponseEntity.ok(updatedMedicalFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalFile(@PathVariable Long id) {
        medicalFileService.deleteMedicalFile(id);
        return ResponseEntity.noContent().build();
    }

}

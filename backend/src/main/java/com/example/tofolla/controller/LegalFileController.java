package com.example.tofolla.controller;

import com.example.tofolla.entity.LegalFile;
import com.example.tofolla.service.LegalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/legal-files")
public class LegalFileController {

    @Autowired
    private LegalFileService legalFileService;

    @GetMapping
    public List<LegalFile> getAllLegalFiles() {
        return legalFileService.getAllLegalFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalFile> getLegalFileById(@PathVariable Long id) {
        Optional<LegalFile> legalFile = legalFileService.getLegalFileById(id);
        return legalFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LegalFile addLegalFile(@RequestBody LegalFile legalFile) {
        return legalFileService.addLegalFile(legalFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalFile> updateLegalFile(@PathVariable Long id, @RequestBody LegalFile legalFileDetails) {
        LegalFile updatedLegalFile = legalFileService.updateLegalFile(id, legalFileDetails);
        return ResponseEntity.ok(updatedLegalFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegalFile(@PathVariable Long id) {
        legalFileService.deleteLegalFile(id);
        return ResponseEntity.noContent().build();
    }
}

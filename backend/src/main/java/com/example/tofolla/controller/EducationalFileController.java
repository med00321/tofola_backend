package com.example.tofolla.controller;

import com.example.tofolla.entity.EducationalFile;
import com.example.tofolla.service.EducationalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/educational-files")
public class EducationalFileController {

    @Autowired
    private EducationalFileService educationalFileService;

    @GetMapping
    public List<EducationalFile> getAllEducationalFiles() {
        return educationalFileService.getAllEducationalFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalFile> getEducationalFileById(@PathVariable Long id) {
        Optional<EducationalFile> educationalFile = educationalFileService.getEducationalFileById(id);
        return educationalFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EducationalFile> addEducationalFile(@RequestBody EducationalFile educationalFile) {
        try {
            EducationalFile savedFile = educationalFileService.addEducationalFile(educationalFile);
            return ResponseEntity.ok(savedFile);
        } catch (RuntimeException e) {
            // Return a bad request with a specific error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationalFile> updateEducationalFile(@PathVariable Long id, @RequestBody EducationalFile educationalFileDetails) {
        try {
            EducationalFile updatedEducationalFile = educationalFileService.updateEducationalFile(id, educationalFileDetails);
            return ResponseEntity.ok(updatedEducationalFile);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducationalFile(@PathVariable Long id) {
        educationalFileService.deleteEducationalFile(id);
        return ResponseEntity.noContent().build();
    }
}

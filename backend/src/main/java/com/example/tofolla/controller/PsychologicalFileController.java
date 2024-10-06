package com.example.tofolla.controller;

import com.example.tofolla.entity.PsychologicalFile;
import com.example.tofolla.service.PsychologicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/psychological-files")
public class PsychologicalFileController {

    @Autowired
    private PsychologicalFileService psychologicalFileService;

    @GetMapping
    public List<PsychologicalFile> getAllPsychologicalFiles() {
        return psychologicalFileService.getAllPsychologicalFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsychologicalFile> getPsychologicalFileById(@PathVariable Long id) {
        Optional<PsychologicalFile> psychologicalFile = psychologicalFileService.getPsychologicalFileById(id);
        return psychologicalFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PsychologicalFile addPsychologicalFile(@RequestBody PsychologicalFile psychologicalFile) {
        return psychologicalFileService.addPsychologicalFile(psychologicalFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PsychologicalFile> updatePsychologicalFile(@PathVariable Long id, @RequestBody PsychologicalFile psychologicalFileDetails) {
        PsychologicalFile updatedPsychologicalFile = psychologicalFileService.updatePsychologicalFile(id, psychologicalFileDetails);
        return ResponseEntity.ok(updatedPsychologicalFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePsychologicalFile(@PathVariable Long id) {
        psychologicalFileService.deletePsychologicalFile(id);
        return ResponseEntity.noContent().build();
    }
}

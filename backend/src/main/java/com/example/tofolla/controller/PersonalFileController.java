package com.example.tofolla.controller;

import com.example.tofolla.entity.PersonalFile;
import com.example.tofolla.service.PersonalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-files")
public class PersonalFileController {

    @Autowired
    private PersonalFileService personalFileService;

    @GetMapping
    public List<PersonalFile> getAllPersonalFiles() {
        return personalFileService.getAllPersonalFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalFile> getPersonalFileById(@PathVariable Long id) {
        Optional<PersonalFile> personalFile = personalFileService.getPersonalFileById(id);
        return personalFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PersonalFile addPersonalFile(@RequestBody PersonalFile personalFile) {
        return personalFileService.addPersonalFile(personalFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalFile> updatePersonalFile(@PathVariable Long id, @RequestBody PersonalFile personalFileDetails) {
        PersonalFile updatedPersonalFile = personalFileService.updatePersonalFile(id, personalFileDetails);
        return ResponseEntity.ok(updatedPersonalFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalFile(@PathVariable Long id) {
        personalFileService.deletePersonalFile(id);
        return ResponseEntity.noContent().build();
    }
}

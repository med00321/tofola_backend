package com.example.tofolla.controller;

import com.example.tofolla.entity.minor;
import com.example.tofolla.service.MinorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/minors")
public class MinorController {

    @Autowired
    private MinorService MinorService;

    @GetMapping
    public List<minor> getAllminors() {
        return MinorService.getAllminors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<minor> getminorById(@PathVariable Long id) {
        Optional<minor> minor = MinorService.getminorById(id);
        return minor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public minor addminor(@RequestBody minor minor) {
        return MinorService.addminor(minor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<minor> updateminor(@PathVariable Long id, @RequestBody minor minorDetails) {
        minor updatedminor = MinorService.updateminor(id, minorDetails);
        return ResponseEntity.ok(updatedminor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteminor(@PathVariable Long id) {
        MinorService.deleteminor(id);
        return ResponseEntity.noContent().build();
    }
}

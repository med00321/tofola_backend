package com.example.tofolla.controller;

import com.example.tofolla.entity.Observation;
import com.example.tofolla.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {

    @Autowired
    private ObservationService observationService;

    @GetMapping
    public List<Observation> getAllObservations() {
        return observationService.getAllObservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observation> getObservationById(@PathVariable Long id) {
        Optional<Observation> observation = observationService.getObservationById(id);
        return observation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Observation addObservation(@RequestBody Observation observation) {
        return observationService.addObservation(observation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Observation> updateObservation(@PathVariable Long id, @RequestBody Observation observationDetails) {
        Observation updatedObservation = observationService.updateObservation(id, observationDetails);
        return ResponseEntity.ok(updatedObservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable Long id) {
        observationService.deleteObservation(id);
        return ResponseEntity.noContent().build();
    }
}

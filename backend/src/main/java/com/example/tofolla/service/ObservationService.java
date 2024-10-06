package com.example.tofolla.service;

import com.example.tofolla.entity.Observation;
import com.example.tofolla.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;

    public List<Observation> getAllObservations() {
        return observationRepository.findAll();
    }

    public Optional<Observation> getObservationById(Long id) {
        return observationRepository.findById(id);
    }

    public Observation addObservation(Observation observation) {
        return observationRepository.save(observation);
    }

    public Observation updateObservation(Long id, Observation observationDetails) {
        Observation observation = observationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observation not found with id " + id));

        // Example of updating fields
        observation.setId(observationDetails.getId());
        observation.setminor(observationDetails.getminor());

        return observationRepository.save(observation);
    }

    public void deleteObservation(Long id) {
        observationRepository.deleteById(id);
    }
}

package com.example.tofolla.service;

import com.example.tofolla.entity.minor;
import com.example.tofolla.repository.MinorRepository;
import com.example.tofolla.repository.EducationalFileRepository;
import com.example.tofolla.repository.MedicalFileRepository;
import com.example.tofolla.repository.LegalFileRepository;
import com.example.tofolla.repository.PsychologicalFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MinorService {

    @Autowired
    private MinorRepository minorRepository;

    @Autowired
    private EducationalFileRepository educationalFileRepository;

    @Autowired
    private MedicalFileRepository medicalFileRepository;

    @Autowired
    private LegalFileRepository legalFileRepository;

    @Autowired
    private PsychologicalFileRepository psychologicalFileRepository;

    public List<minor> getAllminors() {
        return minorRepository.findAll();
    }

    public Optional<minor> getminorById(Long id) {
        return minorRepository.findById(id);
    }

    public minor addminor(minor minor) {
        return minorRepository.save(minor);
    }

    public minor updateminor(Long id, minor minorDetails) {
        minor minor = minorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Minor not found with id " + id));

        minor.setFirstName(minorDetails.getFirstName());
        minor.setLastName(minorDetails.getLastName());
        minor.setAge(minorDetails.getAge());
        minor.setGuardianName(minorDetails.getGuardianName());
        minor.setGuardianContact(minorDetails.getGuardianContact());

        return minorRepository.save(minor);
    }
    public List<minor> getMinorsByUserId(Long userId) {
        return minorRepository.findByUserId(userId);
    }
    @Transactional
    public void deleteminor(Long id) {
        // First, delete related files
        educationalFileRepository.deleteByMinorId(id);
        medicalFileRepository.deleteByMinorId(id);
        legalFileRepository.deleteByMinorId(id);
        psychologicalFileRepository.deleteByMinorId(id);

        // Then, delete the minor
        minorRepository.deleteById(id);
    }
}
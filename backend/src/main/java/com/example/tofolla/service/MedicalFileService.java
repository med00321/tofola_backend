package com.example.tofolla.service;

import com.example.tofolla.entity.MedicalFile;
import com.example.tofolla.repository.MedicalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalFileService {

    @Autowired
    private MedicalFileRepository medicalFileRepository;

    public List<MedicalFile> getAllMedicalFiles() {
        return medicalFileRepository.findAll();
    }

    public Optional<MedicalFile> getMedicalFileById(Long id) {
        return medicalFileRepository.findById(id);
    }

    public MedicalFile addMedicalFile(MedicalFile medicalFile) {
        return medicalFileRepository.save(medicalFile);
    }

    public MedicalFile updateMedicalFile(Long id, MedicalFile medicalFileDetails) {
        MedicalFile medicalFile = medicalFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MedicalFile not found with id " + id));

        // Example of updating fields
        medicalFile.setId(medicalFileDetails.getId());
        medicalFile.setminor(medicalFileDetails.getminor());

        return medicalFileRepository.save(medicalFile);
    }

    public void deleteMedicalFile(Long id) {
        medicalFileRepository.deleteById(id);
    }
}

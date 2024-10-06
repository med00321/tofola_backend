package com.example.tofolla.service;

import com.example.tofolla.entity.EducationalFile;
import com.example.tofolla.entity.minor;
import com.example.tofolla.repository.EducationalFileRepository;
import com.example.tofolla.repository.MinorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationalFileService {

    @Autowired
    private EducationalFileRepository educationalFileRepository;

    @Autowired
    private MinorRepository minorRepository;

    public List<EducationalFile> getAllEducationalFiles() {
        return educationalFileRepository.findAll();
    }

    public Optional<EducationalFile> getEducationalFileById(Long id) {
        return educationalFileRepository.findById(id);
    }

    public EducationalFile addEducationalFile(EducationalFile educationalFile) {
        // Check if the minor exists
        Long minorId = educationalFile.getminor().getId();
        if (!minorRepository.existsById(minorId)) {
            throw new RuntimeException("Minor with ID " + minorId + " does not exist.");
        }
        return educationalFileRepository.save(educationalFile);
    }

    public EducationalFile updateEducationalFile(Long id, EducationalFile educationalFileDetails) {
        EducationalFile educationalFile = educationalFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EducationalFile not found with id " + id));

        // Update fields
        educationalFile.setEducationalBackground(educationalFileDetails.getEducationalBackground());
        educationalFile.setminor(educationalFileDetails.getminor());
        educationalFile.setSchoolEvaluations(educationalFileDetails.getSchoolEvaluations());
        educationalFile.setTrainingAndSkills(educationalFileDetails.getTrainingAndSkills());
        educationalFile.setTrainingDocuments(educationalFileDetails.getTrainingDocuments());

        return educationalFileRepository.save(educationalFile);
    }

    public void deleteEducationalFile(Long id) {
        educationalFileRepository.deleteById(id);
    }
}

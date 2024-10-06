package com.example.tofolla.service;

import com.example.tofolla.entity.LegalFile;
import com.example.tofolla.repository.LegalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalFileService {

    @Autowired
    private LegalFileRepository legalFileRepository;

    public List<LegalFile> getAllLegalFiles() {
        return legalFileRepository.findAll();
    }

    public Optional<LegalFile> getLegalFileById(Long id) {
        return legalFileRepository.findById(id);
    }

    public LegalFile addLegalFile(LegalFile legalFile) {
        return legalFileRepository.save(legalFile);
    }

    public LegalFile updateLegalFile(Long id, LegalFile legalFileDetails) {
        LegalFile legalFile = legalFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LegalFile not found with id " + id));

        // Example of updating fields
        legalFile.setId(legalFileDetails.getId());
        legalFile.setminor(legalFileDetails.getminor());

        return legalFileRepository.save(legalFile);
    }

    public void deleteLegalFile(Long id) {
        legalFileRepository.deleteById(id);
    }
}

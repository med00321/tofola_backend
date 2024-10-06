package com.example.tofolla.service;

import com.example.tofolla.entity.PsychologicalFile;
import com.example.tofolla.repository.PsychologicalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PsychologicalFileService {

    @Autowired
    private PsychologicalFileRepository psychologicalFileRepository;

    public List<PsychologicalFile> getAllPsychologicalFiles() {
        return psychologicalFileRepository.findAll();
    }

    public Optional<PsychologicalFile> getPsychologicalFileById(Long id) {
        return psychologicalFileRepository.findById(id);
    }

    public PsychologicalFile addPsychologicalFile(PsychologicalFile psychologicalFile) {
        return psychologicalFileRepository.save(psychologicalFile);
    }

    public PsychologicalFile updatePsychologicalFile(Long id, PsychologicalFile psychologicalFileDetails) {
        PsychologicalFile psychologicalFile = psychologicalFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PsychologicalFile not found with id " + id));

        // Example of updating fields// hna tat updati chno bghiti ytbdl fhad lfichier
        psychologicalFile.setId(psychologicalFileDetails.getId());
        psychologicalFile.setminor(psychologicalFileDetails.getminor());

        return psychologicalFileRepository.save(psychologicalFile);
    }

    public void deletePsychologicalFile(Long id) {
        psychologicalFileRepository.deleteById(id);
    }
}

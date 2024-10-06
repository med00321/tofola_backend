package com.example.tofolla.service;

import com.example.tofolla.entity.PersonalFile;
import com.example.tofolla.repository.PersonalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalFileService {

    @Autowired
    private PersonalFileRepository personalFileRepository;

    public List<PersonalFile> getAllPersonalFiles() {
        return personalFileRepository.findAll();
    }

    public Optional<PersonalFile> getPersonalFileById(Long id) {
        return personalFileRepository.findById(id);
    }

    public PersonalFile addPersonalFile(PersonalFile personalFile) {
        return personalFileRepository.save(personalFile);
    }

    public PersonalFile updatePersonalFile(Long id, PersonalFile personalFileDetails) {
        PersonalFile personalFile = personalFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PersonalFile not found with id " + id));

        // Example of updating fields
        personalFile.setId(personalFileDetails.getId());
        personalFile.setminor(personalFileDetails.getminor());

        return personalFileRepository.save(personalFile);
    }

    public void deletePersonalFile(Long id) {
        personalFileRepository.deleteById(id);
    }
}

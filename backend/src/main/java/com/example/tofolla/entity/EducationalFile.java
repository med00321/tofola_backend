package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "educational_files")
public class EducationalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "educational_background")
    private String educationalBackground;

    @Column(name = "training_and_skills")
    private String trainingAndSkills;

    @Column(name = "school_evaluations")
    private String schoolEvaluations;

    @Column(name = "training_documents")
    private String trainingDocuments;

    // Constructors
    public EducationalFile() {}

    public EducationalFile(minor minor, String educationalBackground, String trainingAndSkills, String schoolEvaluations, String trainingDocuments) {
        this.minor = minor;
        this.educationalBackground = educationalBackground;
        this.trainingAndSkills = trainingAndSkills;
        this.schoolEvaluations = schoolEvaluations;
        this.trainingDocuments = trainingDocuments;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public minor getminor() {
        return minor;
    }

    public void setminor(minor minor) {
        this.minor = minor;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getTrainingAndSkills() {
        return trainingAndSkills;
    }

    public void setTrainingAndSkills(String trainingAndSkills) {
        this.trainingAndSkills = trainingAndSkills;
    }

    public String getSchoolEvaluations() {
        return schoolEvaluations;
    }

    public void setSchoolEvaluations(String schoolEvaluations) {
        this.schoolEvaluations = schoolEvaluations;
    }

    public String getTrainingDocuments() {
        return trainingDocuments;
    }

    public void setTrainingDocuments(String trainingDocuments) {
        this.trainingDocuments = trainingDocuments;
    }


}

package com.example.tofolla.dto;

public class EducationalFileDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String educationalBackground;
    private String trainingAndSkills;
    private String schoolEvaluations;
    private String trainingDocuments;

    // Constructors
    public EducationalFileDTO() {}

    public EducationalFileDTO(Long id, Long minorId, String educationalBackground, String trainingAndSkills, String schoolEvaluations, String trainingDocuments) {
        this.id = id;
        this.minorId = minorId;
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

    public Long getMinorId() {
        return minorId;
    }

    public void setMinorId(Long minorId) {
        this.minorId = minorId;
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

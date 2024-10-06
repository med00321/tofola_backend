package com.example.tofolla.dto;

public class MedicalFileDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String generalHealth;
    private String contagiousDiseases;
    private String medicalHistory;
    private String medicalDocuments;

    // Constructors
    public MedicalFileDTO() {}

    public MedicalFileDTO(Long id, Long minorId, String generalHealth, String contagiousDiseases, String medicalHistory, String medicalDocuments) {
        this.id = id;
        this.minorId = minorId;
        this.generalHealth = generalHealth;
        this.contagiousDiseases = contagiousDiseases;
        this.medicalHistory = medicalHistory;
        this.medicalDocuments = medicalDocuments;
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

    public String getGeneralHealth() {
        return generalHealth;
    }

    public void setGeneralHealth(String generalHealth) {
        this.generalHealth = generalHealth;
    }

    public String getContagiousDiseases() {
        return contagiousDiseases;
    }

    public void setContagiousDiseases(String contagiousDiseases) {
        this.contagiousDiseases = contagiousDiseases;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalDocuments() {
        return medicalDocuments;
    }

    public void setMedicalDocuments(String medicalDocuments) {
        this.medicalDocuments = medicalDocuments;
    }
}

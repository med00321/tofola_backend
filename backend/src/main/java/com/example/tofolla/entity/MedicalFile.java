package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_files")
public class MedicalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "general_health")
    private String generalHealth;

    @Column(name = "contagious_diseases")
    private String contagiousDiseases;

    @Column(name = "medical_history")
    private String medicalHistory;

    @Column(name = "medical_documents")
    private String medicalDocuments;

    // Constructors
    public MedicalFile() {}

    public MedicalFile(minor minor, String generalHealth, String contagiousDiseases, String medicalHistory, String medicalDocuments) {
        this.minor = minor;
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

    public minor getminor() {
        return minor;
    }

    public void setminor(minor minor) {
        this.minor = minor;
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

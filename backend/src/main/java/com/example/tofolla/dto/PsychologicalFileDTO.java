package com.example.tofolla.dto;

public class PsychologicalFileDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String mentalDisorders;
    private String psychologicalDiseases;
    private String treatmentPlan;

    // Constructors
    public PsychologicalFileDTO() {}

    public PsychologicalFileDTO(Long id, Long minorId, String mentalDisorders, String psychologicalDiseases, String treatmentPlan) {
        this.id = id;
        this.minorId = minorId;
        this.mentalDisorders = mentalDisorders;
        this.psychologicalDiseases = psychologicalDiseases;
        this.treatmentPlan = treatmentPlan;
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

    public String getMentalDisorders() {
        return mentalDisorders;
    }

    public void setMentalDisorders(String mentalDisorders) {
        this.mentalDisorders = mentalDisorders;
    }

    public String getPsychologicalDiseases() {
        return psychologicalDiseases;
    }

    public void setPsychologicalDiseases(String psychologicalDiseases) {
        this.psychologicalDiseases = psychologicalDiseases;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
}

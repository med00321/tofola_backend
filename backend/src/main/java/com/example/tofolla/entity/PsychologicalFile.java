package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "psychological_files")
public class PsychologicalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "mental_disorders")
    private String mentalDisorders;

    @Column(name = "psychological_diseases")
    private String psychologicalDiseases;

    @Column(name = "treatment_plan")
    private String treatmentPlan;

    // Constructors
    public PsychologicalFile() {}

    public PsychologicalFile(minor minor, String mentalDisorders, String psychologicalDiseases, String treatmentPlan) {
        this.minor = minor;
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

    public minor getminor() {
        return minor;
    }

    public void setminor(minor minor) {
        this.minor = minor;
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

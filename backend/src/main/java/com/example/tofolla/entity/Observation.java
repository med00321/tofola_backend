package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "observations")
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "observation_details")
    private String observationDetails;

    // Constructors
    public Observation() {}

    public Observation(minor minor, String observationDetails) {
        this.minor = minor;
        this.observationDetails = observationDetails;
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

    public String getObservationDetails() {
        return observationDetails;
    }

    public void setObservationDetails(String observationDetails) {
        this.observationDetails = observationDetails;
    }
}

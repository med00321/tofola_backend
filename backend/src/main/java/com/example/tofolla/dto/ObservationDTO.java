package com.example.tofolla.dto;

public class ObservationDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String observationDetails;

    // Constructors
    public ObservationDTO() {}

    public ObservationDTO(Long id, Long minorId, String observationDetails) {
        this.id = id;
        this.minorId = minorId;
        this.observationDetails = observationDetails;
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

    public String getObservationDetails() {
        return observationDetails;
    }

    public void setObservationDetails(String observationDetails) {
        this.observationDetails = observationDetails;
    }
}

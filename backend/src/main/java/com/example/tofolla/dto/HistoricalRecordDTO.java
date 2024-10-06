package com.example.tofolla.dto;

public class HistoricalRecordDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String eventDetails;
    private String timestamp;

    // Constructors
    public HistoricalRecordDTO() {}

    public HistoricalRecordDTO(Long id, Long minorId, String eventDetails, String timestamp) {
        this.id = id;
        this.minorId = minorId;
        this.eventDetails = eventDetails;
        this.timestamp = timestamp;
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

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "historical_records")
public class HistoricalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "event_details")
    private String eventDetails;

    @Column(name = "timestamp")
    private String timestamp;

    // Constructors
    public HistoricalRecord() {}

    public HistoricalRecord(minor minor, String eventDetails, String timestamp) {
        this.minor = minor;
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

    public minor getminor() {
        return minor;
    }

    public void setminor(minor minor) {
        this.minor = minor;
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


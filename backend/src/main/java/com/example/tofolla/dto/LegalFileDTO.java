package com.example.tofolla.dto;

public class LegalFileDTO {
    private Long id;
    private Long minorId; // To represent the minor's ID
    private String committedCrimes;
    private String courtJudgments;
    private String ongoingLegalCases;
    private String legalDocuments;

    // Constructors
    public LegalFileDTO() {}

    public LegalFileDTO(Long id, Long minorId, String committedCrimes, String courtJudgments, String ongoingLegalCases, String legalDocuments) {
        this.id = id;
        this.minorId = minorId;
        this.committedCrimes = committedCrimes;
        this.courtJudgments = courtJudgments;
        this.ongoingLegalCases = ongoingLegalCases;
        this.legalDocuments = legalDocuments;
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

    public String getCommittedCrimes() {
        return committedCrimes;
    }

    public void setCommittedCrimes(String committedCrimes) {
        this.committedCrimes = committedCrimes;
    }

    public String getCourtJudgments() {
        return courtJudgments;
    }

    public void setCourtJudgments(String courtJudgments) {
        this.courtJudgments = courtJudgments;
    }

    public String getOngoingLegalCases() {
        return ongoingLegalCases;
    }

    public void setOngoingLegalCases(String ongoingLegalCases) {
        this.ongoingLegalCases = ongoingLegalCases;
    }

    public String getLegalDocuments() {
        return legalDocuments;
    }

    public void setLegalDocuments(String legalDocuments) {
        this.legalDocuments = legalDocuments;
    }
}

package com.example.tofolla.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "legal_files")
public class LegalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "minor_id", nullable = false)
    private minor minor;

    @Column(name = "committed_crimes")
    private String committedCrimes;

    @Column(name = "court_judgments")
    private String courtJudgments;

    @Column(name = "ongoing_legal_cases")
    private String ongoingLegalCases;

    @Column(name = "legal_documents")
    private String legalDocuments;

    // Constructors
    public LegalFile() {}

    public LegalFile(minor minor, String committedCrimes, String courtJudgments, String ongoingLegalCases, String legalDocuments) {
        this.minor = minor;
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

    public minor getminor() {
        return minor;
    }

    public void setminor(minor minor) {
        this.minor = minor;
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

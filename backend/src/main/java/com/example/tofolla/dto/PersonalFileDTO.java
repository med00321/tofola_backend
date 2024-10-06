package com.example.tofolla.dto;

public class PersonalFileDTO {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String familyDetails;

    // Constructors
    public PersonalFileDTO() {}

    public PersonalFileDTO(Long id, String name, String address, String contact, String familyDetails) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.familyDetails = familyDetails;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
    }
}

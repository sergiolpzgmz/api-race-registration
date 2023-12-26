package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regulation_document")
public class regulationDocument {
    @Id
    @GeneratedValue
    @Column(name = "regulation_id", nullable = false, length = 20)
    private String regulationID;
    @Column(name = "regulation_name", nullable = false, length = 80)
    private String regulationName;
    @Lob
    @Column(name = "regulation_document", nullable = false, length = 80)
    private byte[] regulationDocument;

    public String getRegulationID() {
        return regulationID;
    }

    public void setRegulationID(String regulationID) {
        this.regulationID = regulationID;
    }

    public String getRegulationName() {
        return regulationName;
    }

    public void setRegulationName(String regulationName) {
        this.regulationName = regulationName;
    }

    public byte[] getRegulationDocument() {
        return regulationDocument;
    }

    public void setRegulationDocument(byte[] regulationDocument) {
        this.regulationDocument = regulationDocument;
    }
}

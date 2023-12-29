package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regulation_document")
public class RegulationDocument {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 20)
    private String regulationID;

    @Column(name = "name", nullable = false, length = 80)
    private String regulationName;

    @Lob
    @Column(name = "document", columnDefinition = "LONGBLOB")
    private byte[] regulationDocument;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}

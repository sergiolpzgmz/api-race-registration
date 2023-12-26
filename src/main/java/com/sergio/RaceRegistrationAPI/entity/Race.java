package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer raceID;

    @Column(name = "name", nullable = false, length = 100)
    private String raceName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    private java.sql.Date raceDate;

    @Column(name = "location", nullable = false, length = 60)
    private String raceLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regulation_id", nullable = false)
    private RegulationDocument regulationDocument;

    public Integer getRaceID() {
        return raceID;
    }

    public void setRaceID(Integer raceID) {
        this.raceID = raceID;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getRaceLocation() {
        return raceLocation;
    }

    public void setRaceLocation(String raceLocation) {
        this.raceLocation = raceLocation;
    }

    public RegulationDocument getRegulationDocument() {
        return regulationDocument;
    }

    public void setRegulationDocument(RegulationDocument regulationDocument) {
        this.regulationDocument = regulationDocument;
    }
}

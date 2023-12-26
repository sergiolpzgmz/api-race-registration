package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer raceID;
    @Column(name = "race_name", nullable = false, length = 100)
    private String raceName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "race_date", nullable = false)
    private java.sql.Date raceDate;
    @Column(name = "race_location", nullable = false, length = 60)
    private String raceLocation;

    @Column(name = "race_regulation", nullable = false)
    private String regulationId;



    public Integer getId() {
        return raceID;
    }

    public void setId(Integer id) {
        this.raceID = id;
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

    public void setRaceDate(java.sql.Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getRaceLocation() {
        return raceLocation;
    }

    public void setRaceLocation(String raceLocation) {
        this.raceLocation = raceLocation;
    }

    public String getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(String regulationId) {
        this.regulationId = regulationId;
    }
}

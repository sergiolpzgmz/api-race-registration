package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "race_name", nullable = false, length = 100)
    private String raceName;
    @Column(name = "race_date", nullable = false)
    private Date raceDate;
    @Column(name = "race_location", nullable = false, length = 60)
    private String raceLocation;

    @Column(name = "race_regulation", nullable = false)
    private Integer regulationId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(Integer regulationId) {
        this.regulationId = regulationId;
    }
}

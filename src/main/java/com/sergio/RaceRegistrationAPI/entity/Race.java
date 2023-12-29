package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Indexed;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer raceID;

    @Column(name = "name", nullable = false, length = 100)
    private String raceName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    private java.sql.Date raceDate;

    @Column(name = "location", nullable = false, length = 60)
    private String raceLocation;

    @Column(name = "type", nullable = false, length = 60)
    private String raceType;

    @OneToMany(mappedBy = "race")
    private Set<Inscription> inscriptions;

    public Race(String raceName, Date raceDate, String raceLocation, String raceType) {
        this.raceName = raceName;
        this.raceDate = raceDate;
        this.raceLocation = raceLocation;
        this.raceType = raceType;
    }

    public Race() {
    }


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

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceID=" + raceID +
                ", raceName='" + raceName + '\'' +
                ", raceDate=" + raceDate +
                ", raceLocation='" + raceLocation + '\'' +
                ", raceType='" + raceType + '\'' +
                ", inscriptions=" + inscriptions +
                '}';
    }
}

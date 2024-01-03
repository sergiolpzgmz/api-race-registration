package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "race_info")
public class RaceInfo {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(name = "general_info", columnDefinition = "TEXT", nullable = false)
    private String generalInfo;

    public RaceInfo() {
    }

    public RaceInfo(Race race, String generalInfo) {
        this.race = race;
        this.generalInfo = generalInfo;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
    }

}

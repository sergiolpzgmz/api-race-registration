package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "race_info")
public class RaceInfo {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(name = "general_info", columnDefinition = "TEXT", nullable = false)
    private String generalInfo;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

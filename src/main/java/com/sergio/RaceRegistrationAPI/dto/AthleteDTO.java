package com.sergio.RaceRegistrationAPI.dto;

import jakarta.persistence.Column;

public class AthleteDTO {
    private String name;
    private String surnames;
    private String town;
    private String gender;
    private String clubName;

    public AthleteDTO(String name, String surnames, String town, String gender, String clubName) {
        this.name = name;
        this.surnames = surnames;
        this.town = town;
        this.gender = gender;
        this.clubName = clubName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}

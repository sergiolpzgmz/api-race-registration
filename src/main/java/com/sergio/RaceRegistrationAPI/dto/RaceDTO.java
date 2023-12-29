package com.sergio.RaceRegistrationAPI.dto;

import jakarta.persistence.Column;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class RaceDTO {
    private String raceName;
    private Date raceDate;
    private String raceLocation;
    private String raceType;

    public RaceDTO(String raceName, String raceDate, String raceLocation, String raceType) {
        this.raceName = raceName;
        this.raceDate = dateConversion(raceDate);
        this.raceLocation = raceLocation;
        this.raceType = raceType;
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

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    private java.sql.Date dateConversion(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = simpleDateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

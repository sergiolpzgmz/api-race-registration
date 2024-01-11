package com.sergio.RaceRegistrationAPI.dto;

public class InscriptionDTO {
    private Long athleteId;
    private Long raceId;
    private Long categoryId;

    public InscriptionDTO(Long athleteId, Long raceId, Long categoryId) {
        this.athleteId = athleteId;
        this.raceId = raceId;
        this.categoryId = categoryId;
    }


    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

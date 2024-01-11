package com.sergio.RaceRegistrationAPI.dto;

public class InscriptionDTO {
    private Long athleteId;
    private Long raceId;
    private Long categoryId;
    private Long dorsal = 0000L;

    public InscriptionDTO(Long athleteId, Long raceId, Long categoryId) {
        this.athleteId = athleteId;
        this.raceId = raceId;
        this.categoryId = categoryId;
        this.dorsal = setDorsal();
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

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
    }

    public Long setDorsal() {
        return this.dorsal +=1;
    }
}

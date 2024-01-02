package com.sergio.RaceRegistrationAPI.dto;

public class RaceInfoDTO {
    private Long raceId;
    private String generalInfo;

    public RaceInfoDTO(Long raceId, String generalInfo) {
        this.raceId = raceId;
        this.generalInfo = generalInfo;
    }

    public Long getRace_id() {
        return raceId;
    }

    public void setRace_id(Long race_id) {
        this.raceId = raceId;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
    }
}

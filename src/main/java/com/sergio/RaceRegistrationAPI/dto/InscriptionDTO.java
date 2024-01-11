package com.sergio.RaceRegistrationAPI.dto;

import com.sergio.RaceRegistrationAPI.entity.Inscription;
import com.sergio.RaceRegistrationAPI.entity.Race;
import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class InscriptionDTO {
    private Long athleteId;
    private Long raceId;
    private Long categoryId;
    private static AtomicLong dorsalCounter = new AtomicLong(0000L);

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

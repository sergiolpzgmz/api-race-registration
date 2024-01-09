package com.sergio.RaceRegistrationAPI.dto;

import com.sergio.RaceRegistrationAPI.entity.Race;
import java.sql.Time;

public class CategoryDTO {
    private Long raceId;
    private String categoryName;
    private float distance;
    private Time startTime;

    public CategoryDTO(Long raceId, String categoryName, float distance, Time startTime) {
        this.raceId = raceId;
        this.categoryName = categoryName;
        this.distance = distance;
        this.startTime = startTime;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}

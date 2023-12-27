package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "race_category")
public class Category {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Id
    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "distance", nullable = false)
    private float distance;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
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

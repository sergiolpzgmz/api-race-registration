package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "race_category")
public class Category {
    @Id
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

}

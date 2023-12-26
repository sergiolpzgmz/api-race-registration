package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
public class RaceInfo {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(name = "general_info", columnDefinition = "TEXT", nullable = false)
    private String generalInfo;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

}

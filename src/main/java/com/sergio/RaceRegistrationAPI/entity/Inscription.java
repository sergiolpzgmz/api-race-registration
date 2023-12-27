package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "race_inscription")
public class Inscription {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @Column(name = "inscription_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private Date inscriptionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_name", nullable = false)
    private Category categoryName;

    @Column(name = "dorsal", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dorsal;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
    }
}
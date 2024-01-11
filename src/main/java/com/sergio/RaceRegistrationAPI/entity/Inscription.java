package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "race_inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscription_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @OneToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "dorsal", nullable = false)
    private Long dorsal;

    @Column(name = "inscription_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private Date inscriptionDate;

    public Inscription(Race race, Athlete athlete, Category category, Long dorsal) {
        this.race = race;
        this.athlete = athlete;
        this.category = category;
        this.dorsal = dorsal;
    }

    public Inscription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }
}
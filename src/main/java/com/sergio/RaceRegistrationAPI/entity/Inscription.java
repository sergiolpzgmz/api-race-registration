package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "race_inscription")
@IdClass(InscriptionId.class)
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
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @Column(name = "dorsal", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dorsal;

    public Inscription() {
    }

    public Inscription(Race race, Athlete athlete, Date inscriptionDate, Category categoryId, Long dorsal) {
        this.race = race;
        this.athlete = athlete;
        this.inscriptionDate = inscriptionDate;
        this.categoryId = categoryId;
        this.dorsal = dorsal;
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

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
    }
}
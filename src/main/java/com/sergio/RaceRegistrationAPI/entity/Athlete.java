package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "athlete")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "surnames", nullable = false, length = 150)
    private String surnames;

    @Column(name = "town", length = 80)
    private String town;

    @Column(name = "gender", length = 60)
    private String gender;

    @Column(name = "club_name", length = 80)
    private String clubName;

    public Athlete() {
    }

    public Athlete(String name, String surnames, String town, String gender, String clubName) {
        this.name = name;
        this.surnames = surnames;
        this.town = town;
        this.gender = gender;
        this.clubName = clubName;
    }

    @OneToMany(mappedBy = "athlete")
    private Set<Inscription> inscriptions;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}

package com.sergio.RaceRegistrationAPI.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "athlete")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dorsal", nullable = false)
    private Long dorsal;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "surnames", nullable = false, length = 150)
    private String surnames;

    @Column(name = "town", length = 80)
    private String town;

    @Column(name = "gender", length = 60)
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_name", nullable = false)
    private Category category;

    @Column(name = "club_name", length = 80)
    private String clubName;

    @Column(name = "registration_status")
    private boolean registrationStatus;

    @OneToMany(mappedBy = "athlete")
    private Set<Inscription> inscriptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}

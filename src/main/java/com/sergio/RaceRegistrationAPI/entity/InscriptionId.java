package com.sergio.RaceRegistrationAPI.entity;

import java.io.Serializable;

public class InscriptionId implements Serializable {
    private Long race;
    private Long athlete;

    public InscriptionId() {
    }

    public InscriptionId(Long race, Long athlete) {
        this.race = race;
        this.athlete = athlete;
    }
}

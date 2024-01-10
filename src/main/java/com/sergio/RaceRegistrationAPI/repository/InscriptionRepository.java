package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Inscription;
import com.sergio.RaceRegistrationAPI.entity.InscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionId> {
}

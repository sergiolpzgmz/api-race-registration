package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    List<Athlete> findByName(String name);
    List<Athlete> findByClubName(String clubName);
}

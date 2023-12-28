package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
}

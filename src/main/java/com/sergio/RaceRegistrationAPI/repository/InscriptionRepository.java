package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    @Query("SELECT MAX(dorsal) FROM Inscription i WHERE race.raceID = :raceId")
    Long findLastInsertedDorsal(@Param("raceId")Long raceId);

    @Query("SELECT i FROM Inscription i WHERE i.race.raceID = :raceId")
    List<Inscription> findByRaceId(@Param("raceId") Long raceId);

    @Query("SELECT i FROM Inscription i WHERE i.race.raceID = :raceId AND i.category.categoryId = :categoryId")
    List<Inscription> findByRaceAndCategoryId(@Param("raceId") Long raceId, @Param("categoryId") Long categoryId );
}

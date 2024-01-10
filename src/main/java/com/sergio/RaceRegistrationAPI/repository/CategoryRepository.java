package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE race.raceID = :raceId")
    List<Category>findCategoriesByRaceId(@Param("raceId")Long raceId);
}

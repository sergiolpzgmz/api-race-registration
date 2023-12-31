package com.sergio.RaceRegistrationAPI.repository;

import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceInfoRepository extends JpaRepository<RaceInfo, Long> {
}

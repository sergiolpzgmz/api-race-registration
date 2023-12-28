package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;
    public ResponseEntity<List<Race>> getAllRaces() {
        return new ResponseEntity<>(raceRepository.findAll(), HttpStatus.OK);
    }
}

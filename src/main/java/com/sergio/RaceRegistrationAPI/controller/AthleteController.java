package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.AthleteDTO;
import com.sergio.RaceRegistrationAPI.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AthleteController {
    @Autowired
    AthleteService athleteService;

    @PostMapping("athlete")
    public ResponseEntity<AthleteDTO>newAthlete(@RequestBody AthleteDTO athleteDTO){
        try {
            athleteService.saveAthlete(athleteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(athleteDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}

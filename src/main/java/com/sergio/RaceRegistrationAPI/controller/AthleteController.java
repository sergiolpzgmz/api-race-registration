package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.AthleteDTO;
import com.sergio.RaceRegistrationAPI.entity.Athlete;
import com.sergio.RaceRegistrationAPI.exception.ApiRequestExceptionNotFound;
import com.sergio.RaceRegistrationAPI.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AthleteController {
    @Autowired
    AthleteService athleteService;

    @PostMapping("athlete")
    public ResponseEntity<AthleteDTO> newAthlete(@RequestBody AthleteDTO athleteDTO) {
        try {
            athleteService.saveAthlete(athleteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(athleteDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @PutMapping("athlete/{id}")
    public ResponseEntity<Athlete> updateAthlete(@RequestBody AthleteDTO athleteDTO, @PathVariable Long id) {
        try {
            Athlete athleteToUpdate = athleteService.findAthleteById(id);

            if (athleteToUpdate == null) {
                throw new ApiRequestExceptionNotFound("Athlete not found with id: " + id);
            } else {
                athleteService.updateAthlete(athleteDTO, athleteToUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).body(athleteToUpdate);
            }
        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @DeleteMapping("athlete/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id) {
        Athlete athleteToDelete = athleteService.findAthleteById(id);
        if (athleteToDelete == null) {
            throw new ApiRequestExceptionNotFound("Athlete not found with id: " + id);
        } else {
            athleteService.deleteAthlete(athleteToDelete);
            return ResponseEntity.noContent().build();
        }
    }
}

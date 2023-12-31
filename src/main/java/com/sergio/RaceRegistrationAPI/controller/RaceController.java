package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.RaceDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.exception.ApiRequestExceptionNotFound;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RaceController {
    @Autowired
    RaceService raceService;

    @PostMapping("race")
    public ResponseEntity<Race> newRace(@RequestBody RaceDTO raceDTO) {
        try {
            Race newRace = new Race(raceDTO.getRaceName(), (Date) raceDTO.getRaceDate(), raceDTO.getRaceLocation(), raceDTO.getRaceType());
            raceService.saveRace(newRace);
            return ResponseEntity.status(HttpStatus.CREATED).body(newRace);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @PutMapping("race/{id}")
    public ResponseEntity<Race> updateRace(@RequestBody RaceDTO raceDTO, @PathVariable Long id) {
        try {
            Race raceToUpdate = raceService.findRaceById(id);

            if (raceToUpdate == null) {
                throw new ApiRequestExceptionNotFound("Race not found with id: " + id);

            } else {
                raceToUpdate.setRaceName(raceDTO.getRaceName());
                raceToUpdate.setRaceDate(raceDTO.getRaceDate());
                raceToUpdate.setRaceLocation(raceDTO.getRaceLocation());
                raceToUpdate.setRaceType(raceDTO.getRaceType());
                raceService.saveRace(raceToUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).body(raceToUpdate);

            }

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @DeleteMapping("race/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        Race raceToDelete = raceService.findRaceById(id);
        if (raceToDelete == null) {
            throw new ApiRequestExceptionNotFound("Race not found with id: " + id);
        } else{
            raceService.deleteRace(raceToDelete);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("race/{id}")
    public ResponseEntity<Race> showRaceById(@PathVariable Long id) {
        Race race = raceService.findRaceById(id);

        if (race == null) {
            throw new ApiRequestExceptionNotFound("Race not found with id: " + id);
        }
        return ResponseEntity.ok(race);
    }

    @GetMapping("races")
    public ResponseEntity<List<Race>> showRaces() {
        List<Race> races = raceService.getAllRaces();
        if (races.isEmpty()) {
            throw new ApiRequestExceptionNotFound("No races found");
        }
        return ResponseEntity.ok(races);
    }
}

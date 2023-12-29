package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.RaceDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RaceController {
    @Autowired
    RaceService raceService;

    @PostMapping("race")
    public Race newRace(@RequestBody RaceDTO raceDTO) {
        Race newRace = new Race(raceDTO.getRaceName(), (Date) raceDTO.getRaceDate(), raceDTO.getRaceLocation(), raceDTO.getRaceType());
        return raceService.saveRace(newRace);
    }

    @PutMapping("race/{id}")
    public Race updateRace(@RequestBody RaceDTO raceDTO, @PathVariable Integer id) {
        Race raceToUpdate = raceService.findRaceById(id);
        raceToUpdate.setRaceName(raceDTO.getRaceName());
        raceToUpdate.setRaceDate(raceDTO.getRaceDate());
        raceToUpdate.setRaceLocation(raceDTO.getRaceLocation());
        raceToUpdate.setRaceType(raceDTO.getRaceType());
        return raceService.saveRace(raceToUpdate);
    }

    @DeleteMapping("race/{id}")
    public void deleteRace(@PathVariable Integer id) {
        Race raceToDelete = raceService.findRaceById(id);
        raceService.deleteRace(raceToDelete);
    }

    @GetMapping("race/{id}")
    public Race showRaceById(@PathVariable Integer id) {
        return raceService.findRaceById(id);
    }

    @GetMapping("races")
    public List<Race> showRaces() {
        return raceService.getAllRaces();
    }
}

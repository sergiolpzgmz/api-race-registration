package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.RaceDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
@Service
public class RaceService {
    @Autowired
    RaceRepository raceRepository;
    @Transactional
    public Race saveRace(RaceDTO raceDTO){
        Race newRace = new Race(raceDTO.getRaceName(), (Date) raceDTO.getRaceDate(), raceDTO.getRaceLocation(), raceDTO.getRaceType());
        return raceRepository.save(newRace);
    }

    @Transactional
    public Race updateRace(RaceDTO raceDTO, Race raceToUpdate){
        raceToUpdate.setRaceName(raceDTO.getRaceName());
        raceToUpdate.setRaceDate(raceDTO.getRaceDate());
        raceToUpdate.setRaceLocation(raceDTO.getRaceLocation());
        raceToUpdate.setRaceType(raceDTO.getRaceType());
        return raceRepository.save(raceToUpdate);
    }

    @Transactional
    public void deleteRace(Race race){
        raceRepository.delete(race);
    }

    @Transactional(readOnly = true)
    public Race findRaceById(Long id){
        return raceRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }
}

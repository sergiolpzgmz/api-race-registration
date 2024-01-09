package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.AthleteDTO;
import com.sergio.RaceRegistrationAPI.entity.Athlete;
import com.sergio.RaceRegistrationAPI.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    AthleteRepository athleteRepository;

    @Transactional
    public Athlete saveAthlete(AthleteDTO athleteDTO) {
        Athlete newAthlete = new Athlete(athleteDTO.getId(), athleteDTO.getName(), athleteDTO.getSurnames(), athleteDTO.getTown(), athleteDTO.getGender(), athleteDTO.getClubName());
        return athleteRepository.save(newAthlete);
    }

    @Transactional
    public Athlete updateAthlete(AthleteDTO athleteDTO, Athlete athleteToUpdate) {
        athleteToUpdate.setId(athleteDTO.getId());
        athleteToUpdate.setName(athleteDTO.getName());
        athleteToUpdate.setSurnames(athleteDTO.getSurnames());
        athleteToUpdate.setTown(athleteDTO.getTown());
        athleteToUpdate.setClubName(athleteDTO.getClubName());
        return athleteRepository.save(athleteToUpdate);
    }

    @Transactional
    public void deleteAthlete(Athlete athlete) {
        athleteRepository.delete(athlete);
    }

    @Transactional(readOnly = true)
    public Athlete findAthleteById(Long id){
        return athleteRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Athlete> getAthletesByName(String name){
        return athleteRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Athlete> getAthletesByClubName(String name){
        return athleteRepository.findByClub(name);
    }



}

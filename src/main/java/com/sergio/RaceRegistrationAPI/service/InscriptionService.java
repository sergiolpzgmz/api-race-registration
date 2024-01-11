package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.InscriptionDTO;
import com.sergio.RaceRegistrationAPI.entity.Athlete;
import com.sergio.RaceRegistrationAPI.entity.Category;
import com.sergio.RaceRegistrationAPI.entity.Inscription;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;

    @Transactional
    public Inscription saveInscription(InscriptionDTO inscriptionDTO, Race race, Athlete athlete, Category category){
        Inscription inscription = new Inscription(race,athlete,category, inscriptionDTO.getDorsal());
        return inscriptionRepository.save(inscription);
    }
}

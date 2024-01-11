package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.entity.Athlete;
import com.sergio.RaceRegistrationAPI.entity.Category;
import com.sergio.RaceRegistrationAPI.entity.Inscription;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;

    @Transactional
    public Inscription saveInscription(Race race, Athlete athlete, Category category, Long lastDorsal){
        Inscription inscription = new Inscription(race,athlete,category, lastDorsal);
        return inscriptionRepository.save(inscription);
    }

    @Transactional(readOnly = true)
    public Long getLastInsertedDorsal(Long raceId){
        return inscriptionRepository.findLastInsertedDorsal(raceId);
    }

    @Transactional(readOnly = true)
    public List<Inscription> getInscriptionsByRace(Long raceId){
        return inscriptionRepository.findByRaceId(raceId);
    }

    @Transactional(readOnly = true)
    public List<Inscription> getInscriptionsByRaceAndCategory(Long raceId, Long categoryId){
        return inscriptionRepository.findByRaceAndCategoryId(raceId, categoryId);
    }
}

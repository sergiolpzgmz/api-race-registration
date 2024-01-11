package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.InscriptionDTO;
import com.sergio.RaceRegistrationAPI.entity.Athlete;
import com.sergio.RaceRegistrationAPI.entity.Category;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.service.AthleteService;
import com.sergio.RaceRegistrationAPI.service.CategoryService;
import com.sergio.RaceRegistrationAPI.service.InscriptionService;
import com.sergio.RaceRegistrationAPI.service.RaceService;
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
@RequestMapping("/api/v1")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    RaceService raceService;

    @Autowired
    AthleteService athleteService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("inscription")
    public ResponseEntity<InscriptionDTO> newInscription(@RequestBody InscriptionDTO inscriptionDTO) {
        try {
            Race race = raceService.findRaceById(inscriptionDTO.getRaceId());
            Athlete athlete = athleteService.findAthleteById(inscriptionDTO.getAthleteId());
            Category category = categoryService.findCategoryById(inscriptionDTO.getCategoryId());

            Long lastDorsal = inscriptionService.getLastInsertedDorsal(inscriptionDTO.getRaceId());
            if(lastDorsal == null) lastDorsal = 0L;
            inscriptionService.saveInscription(race, athlete, category, lastDorsal);
            return ResponseEntity.status(HttpStatus.CREATED).body(inscriptionDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}

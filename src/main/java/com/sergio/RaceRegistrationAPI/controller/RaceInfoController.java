package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.RaceInfoDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RaceInfo;
import com.sergio.RaceRegistrationAPI.service.RaceInfoService;
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

import java.sql.Date;

@RestController
@RequestMapping("/api/v1/")
public class RaceInfoController {
    @Autowired
    RaceInfoService raceInfoService;
    @Autowired
    RaceService raceService;

    @PostMapping("info")
    public ResponseEntity<RaceInfo> newRaceInfo(@RequestBody RaceInfoDTO raceInfoDTO) {
        try {
            Race race = raceService.findRaceById(raceInfoDTO.getRace_id());
            RaceInfo raceInfo = new RaceInfo(race, raceInfoDTO.getGeneralInfo());
            raceInfoService.saveRaceInfo(raceInfo);
            return ResponseEntity.status(HttpStatus.CREATED).body(raceInfo);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}

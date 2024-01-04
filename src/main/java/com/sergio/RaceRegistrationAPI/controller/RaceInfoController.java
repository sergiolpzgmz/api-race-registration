package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.RaceInfoDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RaceInfo;
import com.sergio.RaceRegistrationAPI.exception.ApiRequestExceptionNotFound;
import com.sergio.RaceRegistrationAPI.service.RaceInfoService;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RaceInfoController {
    @Autowired
    RaceInfoService raceInfoService;
    @Autowired
    RaceService raceService;

    @PostMapping("info")
    public ResponseEntity<RaceInfoDTO> newRaceInfo(@RequestBody RaceInfoDTO raceInfoDTO) {
        try {
            Race race = raceService.findRaceById(raceInfoDTO.getRace_id());
            raceInfoService.saveRaceInfo(raceInfoDTO, race);
            return ResponseEntity.status(HttpStatus.CREATED).body(raceInfoDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @PutMapping("info/{id}")
    public ResponseEntity<RaceInfo> updateInfo(@RequestBody RaceInfoDTO raceInfoDTO, @PathVariable Long id) {
        try {
            RaceInfo raceInfoToUpdate = raceInfoService.findRaceById(id);
            if (raceInfoToUpdate == null) {
                throw new ApiRequestExceptionNotFound("No information available for id: " + id);
            } else {
                raceInfoService.updateRaceInfo(raceInfoDTO, raceInfoToUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).body(raceInfoToUpdate);
            }
        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @DeleteMapping("info/{id}")
    public ResponseEntity<Void> deleteInfo(@PathVariable Long id) {
        RaceInfo raceInfoToDelete = raceInfoService.findRaceById(id);
        if (raceInfoToDelete == null) {
            throw new ApiRequestExceptionNotFound("No information available for id: " + id);
        } else {
            raceInfoService.deleteRaceInfo(raceInfoToDelete);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("info/{id}")
    public ResponseEntity<RaceInfo> showRaceInfoById(@PathVariable Long id) {
        RaceInfo raceInfo = raceInfoService.findRaceById(id);
        if (raceInfo == null) {
            throw new ApiRequestExceptionNotFound("No information available for id: " + id);
        }
        return ResponseEntity.ok(raceInfo);
    }
}

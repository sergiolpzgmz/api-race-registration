package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RaceController {
    @Autowired
    RaceService raceService;

    @GetMapping("/races")
    public ResponseEntity<?> getAllRaces(){
        return raceService.getAllRaces();
    }
}

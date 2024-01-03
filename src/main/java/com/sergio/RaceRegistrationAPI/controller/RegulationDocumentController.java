package com.sergio.RaceRegistrationAPI.controller;


import com.sergio.RaceRegistrationAPI.dto.RegulationDocumentDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RegulationDocument;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import com.sergio.RaceRegistrationAPI.service.RegulationDocumentService;
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
public class RegulationDocumentController {
    @Autowired
    RegulationDocumentService regulationDocumentService;

    @Autowired
    RaceService raceService;

    @PostMapping("regulation")
    public ResponseEntity<RegulationDocument> newRegulationDocument(@RequestBody RegulationDocumentDTO regulationDocumentDTO) {
        try {
            Race race = raceService.findRaceById(regulationDocumentDTO.getRaceId());
            RegulationDocument newRegulationDocument = new RegulationDocument(regulationDocumentDTO.getRegulationId(), regulationDocumentDTO.getRegulationName(), regulationDocumentDTO.getRegulationDocument(), race);
            regulationDocumentService.saveRegulation(newRegulationDocument);
            return ResponseEntity.status(HttpStatus.CREATED).body(newRegulationDocument);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}

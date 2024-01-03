package com.sergio.RaceRegistrationAPI.controller;


import com.sergio.RaceRegistrationAPI.dto.RegulationDocumentDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RegulationDocument;
import com.sergio.RaceRegistrationAPI.exception.ApiRequestExceptionNotFound;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import com.sergio.RaceRegistrationAPI.service.RegulationDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("regulation/{id}")
    public ResponseEntity<RegulationDocument> updateRegulationDocument(@RequestBody RegulationDocumentDTO regulationDocumentDTO, @PathVariable String id) {
        try {
            RegulationDocument regulationDocument = regulationDocumentService.findRegulationDocumentById(id);
            if (regulationDocument == null) {
                throw new ApiRequestExceptionNotFound("Regulation not found with id: " + id);
            } else {
                regulationDocument.setRegulationName(regulationDocumentDTO.getRegulationName());
                regulationDocument.setRegulationDocument(regulationDocumentDTO.getRegulationDocument());
                regulationDocumentService.saveRegulation(regulationDocument);
                return ResponseEntity.status(HttpStatus.CREATED).body(regulationDocument);
            }
        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}

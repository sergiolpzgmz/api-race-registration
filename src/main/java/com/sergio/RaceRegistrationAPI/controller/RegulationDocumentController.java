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
    public ResponseEntity<RegulationDocumentDTO> newRegulationDocument(@RequestBody RegulationDocumentDTO regulationDocumentDTO) {
        try {
            Race race = raceService.findRaceById(regulationDocumentDTO.getRaceId());
            regulationDocumentService.saveRegulation(regulationDocumentDTO, race);
            return ResponseEntity.status(HttpStatus.CREATED).body(regulationDocumentDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @PutMapping("regulation/{id}")
    public ResponseEntity<RegulationDocument> updateRegulationDocument(@RequestBody RegulationDocumentDTO regulationDocumentDTO, @PathVariable String id) {
        try {
            RegulationDocument regulationDocumentToUpdate = regulationDocumentService.findRegulationDocumentById(id);
            if (regulationDocumentToUpdate == null) {
                throw new ApiRequestExceptionNotFound("Regulation not found with id: " + id);
            } else {
                regulationDocumentService.updateRegulation(regulationDocumentDTO, regulationDocumentToUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).body(regulationDocumentToUpdate);
            }
        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @DeleteMapping("regulation/{id}")
    public ResponseEntity<Void> deleteRegulation(@PathVariable String id) {
        RegulationDocument regulationDocumentToFind = regulationDocumentService.findRegulationDocumentById(id);
        if (regulationDocumentToFind == null) {
            throw new ApiRequestExceptionNotFound("Regulation not found with id: " + id);
        } else {
            RegulationDocument regulationDocumentToDelete = new RegulationDocument(regulationDocumentToFind.getRegulationID(), regulationDocumentToFind.getRegulationName(), regulationDocumentToFind.getRegulationDocument());
            regulationDocumentService.deleteRegulation(regulationDocumentToDelete);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("regulation/{id}")
    public ResponseEntity<RegulationDocument> showRegulation(@PathVariable String id) {
        RegulationDocument regulationDocument = regulationDocumentService.findRegulationDocumentById(id);
        if (regulationDocument == null) {
            throw new ApiRequestExceptionNotFound("Regulation not found with id: " + id);
        }
        return ResponseEntity.ok(regulationDocument);
    }
}

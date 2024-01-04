package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.RegulationDocumentDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RegulationDocument;
import com.sergio.RaceRegistrationAPI.repository.RegulationDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegulationDocumentService {
    @Autowired
    RegulationDocumentRepository regulationDocumentRepository;

    @Transactional
    public RegulationDocument saveRegulation(RegulationDocumentDTO regulationDocumentDTO, Race race) {
        RegulationDocument newRegulationDocument = new RegulationDocument(regulationDocumentDTO.getRegulationId(), regulationDocumentDTO.getRegulationName(), regulationDocumentDTO.getRegulationDocument(), race);
        return regulationDocumentRepository.save(newRegulationDocument);
    }

    @Transactional
    public RegulationDocument updateRegulation(RegulationDocumentDTO regulationDocumentDTO, RegulationDocument regulationDocumentToUpdate) {
        regulationDocumentToUpdate.setRegulationName(regulationDocumentDTO.getRegulationName());
        regulationDocumentToUpdate.setRegulationDocument(regulationDocumentDTO.getRegulationDocument());
        return regulationDocumentRepository.save(regulationDocumentToUpdate);
    }

    @Transactional
    public void deleteRegulation(RegulationDocument regulationDocument) {
        regulationDocumentRepository.delete(regulationDocument);
    }

    @Transactional(readOnly = true)
    public RegulationDocument findRegulationDocumentById(String id) {
        return regulationDocumentRepository.findById(id).orElse(null);
    }
}

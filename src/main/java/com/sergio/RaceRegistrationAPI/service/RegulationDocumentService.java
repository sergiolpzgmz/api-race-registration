package com.sergio.RaceRegistrationAPI.service;

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
    public RegulationDocument saveRegulation(RegulationDocument regulationDocument) {
        return regulationDocumentRepository.save(regulationDocument);
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

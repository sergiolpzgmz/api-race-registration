package com.sergio.RaceRegistrationAPI.dto;

public class RegulationDocumentDTO {
    private String regulationId;
    private Long raceId;
    private String regulationName;
    private byte[] regulationDocument;

    public RegulationDocumentDTO(String regulationId, Long raceId, String regulationName, byte[] regulationDocument) {
        this.regulationId = regulationId;
        this.raceId = raceId;
        this.regulationName = regulationName;
        this.regulationDocument = regulationDocument;
    }

    public String getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(String regulationId) {
        this.regulationId = regulationId;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public String getRegulationName() {
        return regulationName;
    }

    public void setRegulationName(String regulationName) {
        this.regulationName = regulationName;
    }

    public byte[] getRegulationDocument() {
        return regulationDocument;
    }

    public void setRegulationDocument(byte[] regulationDocument) {
        this.regulationDocument = regulationDocument;
    }
}

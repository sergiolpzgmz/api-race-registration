package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.RaceInfoDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.entity.RaceInfo;
import com.sergio.RaceRegistrationAPI.repository.RaceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RaceInfoService {
    @Autowired
    RaceInfoRepository raceInfoRepository;
    @Transactional
    public RaceInfo saveRaceInfo(RaceInfoDTO raceInfoDTO, Race race){
        RaceInfo raceInfo = new RaceInfo(race, raceInfoDTO.getGeneralInfo());
        return raceInfoRepository.save(raceInfo);
    }

    @Transactional
    public RaceInfo updateRaceInfo(RaceInfoDTO raceInfoDTO, RaceInfo raceInfoToUpdate) {
        raceInfoToUpdate.setGeneralInfo(raceInfoDTO.getGeneralInfo());
        return raceInfoRepository.save(raceInfoToUpdate);
    }

    @Transactional
    public void deleteRaceInfo(RaceInfo raceInfo){
        raceInfoRepository.delete(raceInfo);
    }

    @Transactional(readOnly = true)
    public RaceInfo findRaceById(Long id){
      return raceInfoRepository.findById(id).orElse(null);
    }

}

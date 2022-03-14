package com.cfmgg.vpick.services;

import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    public List<Station> getListStations(){
        return stationRepository.findAll();
    }

    public void registerNewStation(Station station){
        stationRepository.save(station);
    }

    public List<Station> findStationByStatus(StatusStation statusStation){
        return stationRepository.findStationByStatus(statusStation);
    }
    public List<Station> getStationByAdresse(String adresse){
        return stationRepository.findStationByAdresse(adresse);
    }

    public Station getStationById(Long id){
        return stationRepository.findStationById(id);
    }
}

package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    @Autowired

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }
}

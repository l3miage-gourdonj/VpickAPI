package com.cfmgg.vpick.repository;


import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
class StationTest {

    @Autowired
    private StationRepository stationRepository;

    @Test
    public void shouldSaveStation(){
        Station station = new Station("Les Taillés", StatusStation.VNUL);
        stationRepository.save(station);
        List<Station> stationFound = stationRepository.findStationByAdresse(station.getAdresse());
        for(Station s: stationFound){
            if (s.equals(station)){
                assertThat(s.getId()).isEqualTo(station.getId());
            }
        }
    }

    @Test
    public void shouldFindStationVPLUS(){
        List<Station> stations = stationRepository.findStationByStatus(StatusStation.VPLUS);
        int numStations = stations.size();
        assertThat(numStations).isEqualTo(3);
    }

    @Test
    public void shouldNotSaveStationWithSameAdresse(){
        List<Station> stations = stationRepository.findAll();
        Station station = new Station("Victor Hugo", StatusStation.VNUL);
        try{
            stationRepository.save(station);
        }catch(Exception e){
            e.printStackTrace();
        }
        List<Station> stationsApresAjout = stationRepository.findAll();
        assertThat(stations.size()).isEqualTo(stationsApresAjout.size());
    }

}
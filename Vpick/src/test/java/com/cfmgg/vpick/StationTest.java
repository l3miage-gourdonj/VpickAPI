package com.cfmgg.vpick;

import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.StationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StationTest {
    @Autowired
    private StationRepository stationRepository;

    @Test
    public void shouldSaveStation(){
        Station station = new Station("Les Taillés");
        stationRepository.save(station);
        List<Station> stationFound = stationRepository.findAll();
        for(Station s: stationFound){
            if (s.equals(station)){
                assertThat(s.getId()).isEqualTo(station.getId());
            }
        }
    }
}
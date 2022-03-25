package com.cfmgg.vpick;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.StationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * Verifie si la station peut accueillir une location de 3 vélos étant donné qu'elle a 3 places de libres
     */
    @Test
    public void shouldFindStationLibre() {
        Station station = new Station("Condillac");
        List<Bornette> bornettes = new ArrayList<>();
        int random = 3;
        for(int i = 0;i<random ; i++){
            Bornette b = new Bornette(i+1, Etat.OK,null);
            bornettes.add(b);
        }
        station.setBornettes(bornettes);

        stationRepository.save(station);

        List<Station> stationFound = stationRepository.getStationLibres(3);
        for(Station s: stationFound){
            if (s.equals(station)){
                assertThat(s.getId()).isEqualTo(station.getId());
            }
        }
    }


}
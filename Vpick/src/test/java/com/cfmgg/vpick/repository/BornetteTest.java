package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.VpickApplication;
import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class BornetteTest {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private BornetteRepository bornetteRepository;

    @Test
    public void shouldSaveBornette(){
        Station station = stationRepository.findStationById(1L);
        Bornette bornette = new Bornette(Etat.OK, station);
        bornetteRepository.save(bornette);
        Bornette bornetteFound = bornetteRepository.findBornetteById(bornette.getId());
        assertThat(bornetteFound.getId()).isEqualTo(bornette.getId());
    }
    @Test
    public void shouldFindAllBornettes(){
        List<Bornette> bornettesHs = bornetteRepository.findBornetteByEtat(Etat.HS);
        List<Bornette> bornettesOK = bornetteRepository.findBornetteByEtat(Etat.OK);
        List<Bornette> bornettes = bornetteRepository.findAll();
        assertThat(bornettes.size()).isEqualTo(bornettesOK.size()+bornettesHs.size());
    }

    @Test
    public void shouldFindHsBornette(){
        List<Bornette> bornettes = bornetteRepository.findBornetteByEtat(Etat.HS);
        for(Bornette b: bornettes){
            assertThat(b.getEtat()).isEqualTo(Etat.HS);
        }
        System.out.println("taille de bornettes : "+bornettes.size());
    }

}
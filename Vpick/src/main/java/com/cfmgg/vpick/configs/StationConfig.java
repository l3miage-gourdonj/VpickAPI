package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StationConfig {
    @Bean
    CommandLineRunner commandLineRunnerStation(StationRepository stationRepository) {
        return args -> {
            Station notreDameMusee = new Station("Notre Dame Musée");
            Station victorHugo = new Station("Victor Hugo");
            Station gabrielFaure = new Station("Gabriel Fauré");
            Station laTronche = new Station("La Tronche");
            Station saintClaire = new Station("Saint Claire Les Halles");
            Station bibliothequeUniv = new Station("Bibliotheque Universitaire");




            Station ileVerte = new Station("Ile Verte");

            List<Station> stations = List.of(notreDameMusee, victorHugo, gabrielFaure, ileVerte, laTronche, saintClaire, bibliothequeUniv);

            for(Station s: stations){
                List<Bornette> bornettes = new ArrayList<>();
                int random = (int)(Math.random()*(30-5))+5;
                for(int i = 0;i<random ; i++){
                    Bornette b = new Bornette(i+1, Etat.OK,null);
                    bornettes.add(b);
                }
                s.setBornettes(bornettes);
            }
            stationRepository.saveAll(stations);

            System.out.println("Enregistrement des stations");

            System.out.println("End of StationConfig file");
        };
    }
}

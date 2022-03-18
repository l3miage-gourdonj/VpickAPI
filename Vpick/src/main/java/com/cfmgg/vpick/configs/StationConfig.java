package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import com.cfmgg.vpick.repositories.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StationConfig {
    @Bean
    CommandLineRunner commandLineRunnerStation(StationRepository stationRepository) {
        return args -> {
            Station notreDameMusee = new Station("Notre Dame Musée");
            Station victorHugo = new Station("Victor Hugo");
            Station gabrielFaure = new Station("Gabriel Fauré");
            Station ileVerte = new Station("Ile Verte");
            Station laTronche = new Station("La Tronche");
            Station saintClaire = new Station("Saint Claire Les Halles");
            Station bibliothequeUniv = new Station("Bibliotheque Universitaire");


            stationRepository.saveAll(List.of(notreDameMusee, victorHugo, gabrielFaure, ileVerte, laTronche, saintClaire, bibliothequeUniv));

            System.out.println("Enregistrement des stations");

            System.out.println("End of StationConfig file");
        };
    }
}

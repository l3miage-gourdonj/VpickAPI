package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repository.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StationConfig {
    @Bean(name = "beanStation")
    CommandLineRunner commandLineRunnerStation(StationRepository stationRepository) {
        return args -> {
            Station notreDameMusee = new Station("Notre Dame Musée", StatusStation.VMOINS);
            Station victorHugo = new Station("Victor Hugo", StatusStation.VPLUS);
            Station gabrielFaure = new Station("Gabriel Fauré", StatusStation.VPLUS);
            Station ileVerte = new Station("Ile Verte", StatusStation.VNUL);
            Station laTronche = new Station("La Tronche", StatusStation.VMOINS);
            Station saintClaire = new Station("Saint Claire Les Halles", StatusStation.VNUL);
            Station bibliothequeUniv = new Station("Bibliotheque Universitaire", StatusStation.VPLUS);


            stationRepository.saveAll(List.of(notreDameMusee, victorHugo, gabrielFaure, ileVerte, laTronche, saintClaire, bibliothequeUniv));

            System.out.println("Enregistrement des stations");

            System.out.println("End of StationConfig file");
        };
    }

}

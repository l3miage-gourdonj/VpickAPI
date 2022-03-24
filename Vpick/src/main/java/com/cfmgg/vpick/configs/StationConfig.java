package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.PlageHoraire;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.PlageHoraireRepository;
import com.cfmgg.vpick.repositories.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
public class StationConfig {
    @Bean
    CommandLineRunner commandLineRunnerStation(StationRepository stationRepository, PlageHoraireRepository plageHoraireRepository) {
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
                List<PlageHoraire> listPlage = new ArrayList<>();
                int randomStatus = (int)(Math.random()*(2));
                PlageHoraire p1 = new PlageHoraire(StatusStation.values()[randomStatus],new Date(2022,03,24,00,00),new Date(2022,03,24,5,59));
                listPlage.add(p1);
                randomStatus = (int)(Math.random()*(2));
                PlageHoraire p2 = new PlageHoraire(StatusStation.values()[randomStatus],new Date(2022,03,24,6,00),new Date(2022,03,24,11,59));
                listPlage.add(p2);
                randomStatus = (int)(Math.random()*(2));
                PlageHoraire p3 = new PlageHoraire(StatusStation.values()[randomStatus],new Date(2022,03,24,12,00),new Date(2022,03,24,17,59));
                listPlage.add(p3);
                randomStatus = (int)(Math.random()*(2));
                PlageHoraire p4 = new PlageHoraire(StatusStation.values()[randomStatus],new Date(2022,03,24,18,00),new Date(2022,03,24,23,59));
                listPlage.add(p4);
                plageHoraireRepository.saveAll(listPlage);
                s.setPlagesHoraires(listPlage);
            }
            stationRepository.saveAll(stations);

            System.out.println("Enregistrement des stations");

            System.out.println("End of StationConfig file");
        };
    }
}

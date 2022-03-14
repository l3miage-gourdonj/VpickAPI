package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repository.BornetteRepository;
import com.cfmgg.vpick.repository.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BornetteConfig {/*
    @Bean
    @DependsOn("beanStation")
    CommandLineRunner commandLineRunnerBornette(BornetteRepository bornetteRepository,StationRepository stationRepository) {
        return args -> {

        List<Station> stations = stationRepository.findAll();

        System.out.println("Stations trouvés: " + stations);
        for(Station s: stations){
            List<Bornette> bornettes = new ArrayList<>();
            int nbBornette =  3 + (int)(Math.random() * ((18 - 3) + 1));
            for(int i=0; i<nbBornette; i++){
                Etat etat = Etat.OK;
                int nombreAleatoire = (int) (Math.random() * ((8) + 1));
                if(nombreAleatoire>=8)
                    etat = Etat.HS;
                bornettes.add(new Bornette(etat, s));
            }
            System.out.println("Enregistrement des bornettes");
            bornetteRepository.saveAll(bornettes);
        }

            System.out.println("End of BornetteConfig file");
            System.out.println("Taille bornettes : "+ bornetteRepository.findAll().size());
        };
    }
    */
}

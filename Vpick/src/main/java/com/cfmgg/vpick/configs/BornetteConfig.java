package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.repositories.BornetteRepository;
import com.cfmgg.vpick.repositories.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BornetteConfig {
    @Bean
    CommandLineRunner commandLineRunnerBornette(BornetteRepository bornetteRepository, StationRepository stationRepository) {
        return args -> {

            for(Station station: stationRepository.findAll()){
                List<Bornette> bornettes = new ArrayList<Bornette>();
                int random = (int)(Math.random()*(20-5))+5;
                for(int i = 0;i<random ; i++){
                    Bornette b = new Bornette(i+1,Etat.OK,null);
                    bornettes.add(b);
                }
                bornetteRepository.saveAll(bornettes);
            }

        };
    }
}

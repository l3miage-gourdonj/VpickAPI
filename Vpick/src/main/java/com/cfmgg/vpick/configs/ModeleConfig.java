package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.repositories.ModeleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModeleConfig {
    @Bean
    CommandLineRunner commandLineRunnerModele(ModeleRepository modeleRepository) {
        return args -> {
            Modele btwin = new Modele("B'TWIN",9.99F);
            Modele scott = new Modele("SCOTT",18.99F);
            Modele rocky = new Modele("Rocky Mountain", 13.99F);
            Modele mbk = new Modele("MBK", 9.99F);
            Modele lapierre = new Modele("La pierre", 25.99F);

            modeleRepository.saveAll(List.of(btwin, scott, rocky, mbk, lapierre));
            System.out.println("End of ModeleConfig file");
        };
    }
}

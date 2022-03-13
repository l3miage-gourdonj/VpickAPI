package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repository.BornetteRepository;
import com.cfmgg.vpick.repository.ModeleRepository;
import com.cfmgg.vpick.repository.VeloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class VeloConfig {
    @Bean
    CommandLineRunner commandLineRunnerVelo(VeloRepository veloRepository,
                                            ModeleRepository modeleRepository,
                                            BornetteRepository bornetteRepository) {
        return args -> {

            List<Bornette> bornettes = bornetteRepository.findAll();
            List<Modele> modeles = modeleRepository.findAll();
            List<Velo> velos = new ArrayList<>();

            for (Bornette bornette : bornettes) {
                int modeleRandom = 1 + (int) (Math.random() * ((modeles.size() - 1) + 1));
                Modele modele = modeles.get(modeleRandom - 1);
                Etat etat = Etat.OK;
                int etatRandom = (int) (Math.random() * ((8) + 1));
                if (etatRandom >= 8)
                    etat = Etat.HS;

                StatusVelo statusVelo = StatusVelo.LIBRE;
                /*
                int statusRandom = (int) (Math.random() * ((10) + 1));
                if (statusRandom == 10) {
                    statusVelo = StatusVelo.MAINTENANCE;
                } else if (statusRandom > 5) {
                    statusVelo = StatusVelo.LOUE;
                }
                */
                LocalDate start = LocalDate.of(2015, Month.OCTOBER, 14);
                LocalDate end = LocalDate.now();
                LocalDate random = between(start, end);
                Date date = Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());

                Velo velo = new Velo(date, etat, statusVelo, modele, bornette);
                velos.add(velo);
            }
            veloRepository.saveAll(velos);
        };
    }

    /**
     * Generate a random date
     */
    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }


}

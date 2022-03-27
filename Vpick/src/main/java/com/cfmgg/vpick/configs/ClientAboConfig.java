package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Sexe;
import com.cfmgg.vpick.models.ClientAbonne;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
public class ClientAboConfig {
    /*
    @Bean
    CommandLineRunner commandLineRunnerClientAbo(ClientAboRepository clientAboRepository) {
        return args -> {
            //Créations de clients abonnés

            ClientAbonne georges = new ClientAbonne("1234 2345 2345 8793",
                    "Beaux-Art",
                    "Georges",
                    new GregorianCalendar(2004, Calendar.MARCH, 15).getTime(),
                    "Rue de la pierre",
                    Sexe.HOMME,
                    "23456",
                    0,
                    new GregorianCalendar(2022, Calendar.DECEMBER, 2).getTime(),
                    new GregorianCalendar(2023, Calendar.DECEMBER, 2).getTime()
            );
            ClientAbonne yves = new ClientAbonne("1234 2345 2345 8793",
                    "LaForet",
                    "Yves",
                    new GregorianCalendar(1982, Calendar.FEBRUARY, 11).getTime(),
                    "Rue des poires",
                    Sexe.HOMME,
                    "12345",
                    0,
                    new GregorianCalendar(2018, Calendar.APRIL, 11).getTime(),
                    new GregorianCalendar(2019, Calendar.APRIL, 11).getTime()
            );
            System.out.println("Enregistrement de nos clients.");
            clientAboRepository.saveAll(List.of(yves, georges));
            System.out.println("End of ClientConfig file");
        };
    }*/
}

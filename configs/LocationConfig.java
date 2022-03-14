package com.cfmgg.vpick.configs;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.*;
import com.cfmgg.vpick.repository.ClientRepository;
import com.cfmgg.vpick.repository.LocationRepository;
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
public class LocationConfig {/*
    @Bean
    CommandLineRunner commandLineRunnerLocation(LocationRepository locationRepository,
                                                VeloRepository veloRepository,
                                                ClientRepository clientRepository) {
        return args -> {

            List<ClientAbonne> clientsAbonne = clientRepository.findAllClientAbonne();
            List<Velo> listVelo = veloRepository.findAll();
            for(ClientAbonne clientAbonne : clientsAbonne) {

                int randomNbLocation = (int) (1 + Math.random() * ((5 + 1) + 1));
                for(int i=0; i<randomNbLocation; i++) {
                    List<Velo> velos = new ArrayList<>();
                    //Velo velo = bornetteRepository.findVeloFromBornetteId(1L);


                    int randomNbVelo = (int) (1 + Math.random() * ((velos.size() + 3) + 1));
                    for (int j = 0; j < randomNbVelo; j++) {
                        if (listVelo.get(j).getStatus() == StatusVelo.LIBRE) {
                            if (listVelo.get(j).getBornette().getEtat() == Etat.OK) {
                                velos.add(listVelo.get(j));
                                //veloRepository.updateStatusVelo(StatusVelo.LIBRE, listVelo.get(i).getId());
                            }
                        }
                    }
                    Date debut = randomDate(LocalDate.of(2015, Month.OCTOBER, 14), LocalDate.now());
                    // To calculate the time difference of two dates
                    boolean isSup4day = debut.getTime() > 86400000*4;

                    Date dateFin = null;
                    if(isSup4day){
                        int RandomTime = (int)(Math.random()*86400000*4);
                        dateFin= new Date(debut.getTime() + RandomTime);

                    }
                    //Date fin = randomDate( Instant.ofEpochMilli(debut.getTime()).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());


                    locationRepository.save(new Location(velos, clientAbonne, debut, dateFin, clientAbonne.getCodeSecret()));
                }
            }


            List<Client> clientsNonAbonne = clientRepository.findAllClientNonAbonne();
            for(Client c : clientsNonAbonne){
                List<Velo> velosLibres = veloRepository.findVeloByStatus(StatusVelo.LIBRE);
                List<Velo> veloLouee = new ArrayList<Velo>();
                int randomNbVelo = (int) (1 + Math.random() * ((4 + 1) + 1));
                for(int i = 0; i<randomNbVelo;i++){
                    int randomNumVelo = (int) (1 + Math.random() * ((velosLibres.size()) + 1));
                    veloLouee.add(velosLibres.get(randomNumVelo-1));
                    velosLibres.remove(randomNumVelo-1);
                    //update status velo

                }
                Date debut = randomDate(LocalDate.of(2015, Month.OCTOBER, 14), LocalDate.now());
                boolean isSup4day = debut.getTime() > 86400000*4;

                Date dateFin = null;
                if(isSup4day){
                    int RandomTime = (int)(Math.random()*86400000*4);
                    dateFin= new Date(debut.getTime() + RandomTime);
                }
                String codeSecret = "" +gen();


                locationRepository.save(new Location(veloLouee, c, debut, dateFin, codeSecret));
            }

        };*/


    private Date randomDate(LocalDate start, LocalDate end){
        LocalDate random = between(start, end);
        return Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());
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

    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}

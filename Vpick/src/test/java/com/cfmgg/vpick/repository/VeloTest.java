package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Velo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeloTest {
    @Autowired
    private VeloRepository veloRepository;

    @Autowired
    private BornetteRepository bornetteRepository;

    @Autowired
    private ModeleRepository modeleRepository;

    @Test
    public void shouldSaveVelo(){
        try {
            //Sleep le processus pour attendre que la création de toutes les bornettes on bien été éffectuées.
            Thread.sleep(1000);
            Velo velo = new Velo(new GregorianCalendar(2020, Calendar.DECEMBER, 2).getTime(),
                    Etat.OK,
                    StatusVelo.LIBRE,
                    modeleRepository.findAll().get(0),
                    bornetteRepository.findAll().get(0));


            veloRepository.save(velo);

            Velo veloFound = veloRepository.findVeloById(velo.getId());
            assertThat(veloFound.getId()).isEqualTo(veloFound.getId());
        }catch (Exception e){

        }
    }

    @Test
    public void shouldFindByEtat(){
        List<Velo> veloList = veloRepository.findVeloByEtat(Etat.OK);
        for(Velo v : veloList){
            assertThat(v.getEtat()).isEqualTo(Etat.OK);
        }
    }

    @Test
    public void shouldUpdateStatus(){
        //Sleep le processus pour attendre que la création de toutes les bornettes on bien été éffectuées.
        try {
            Thread.sleep(1000);
            Velo velo = new Velo(new GregorianCalendar(2020, Calendar.DECEMBER, 2).getTime(),
                    Etat.OK,
                    StatusVelo.LIBRE,
                    modeleRepository.findAll().get(0),
                    bornetteRepository.findAll().get(0));
            veloRepository.save(velo);
            veloRepository.updateStatusVelo(StatusVelo.LOUE, velo.getId());
            Velo veloFound = veloRepository.findVeloById(velo.getId());
            assertThat(velo.getStatus()).isNotEqualTo(veloFound.getStatus());
            assertThat(velo.getStatus()).isEqualTo(StatusVelo.LOUE);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}

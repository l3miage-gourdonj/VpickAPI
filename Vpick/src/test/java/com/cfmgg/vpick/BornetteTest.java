package com.cfmgg.vpick;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.Sexe;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.ClientAbonne;
import com.cfmgg.vpick.repositories.BornetteRepository;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class BornetteTest {

    @Autowired
    private BornetteRepository bornetteRepository;

    /**
     * Dans le test suivant on ne verifie pas que la bornette est associées à une station
     * mais que la bornette créée s'enregistre bien dans la bd
     */
    @Test
    public void shouldSaveBornette(){
        Bornette bornette = new Bornette(1001, Etat.OK, null);
        bornetteRepository.save(bornette);
        Bornette bornetteFound = bornetteRepository.findBornetteById(bornette.getId());
        assertThat(bornetteFound.getId()).isEqualTo(bornette.getId());

    }
}

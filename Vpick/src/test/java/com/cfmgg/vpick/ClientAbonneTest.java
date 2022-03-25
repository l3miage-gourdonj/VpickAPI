package com.cfmgg.vpick;

import com.cfmgg.vpick.enums.Sexe;
import com.cfmgg.vpick.models.ClientAbonne;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientAbonneTest {
    @Autowired
    private ClientAboRepository clientAboRepository;

    @Test
    public void shouldSaveClientAbonne(){
        ClientAbonne clement = new ClientAbonne("1234 2345 2345 9999",
                "LaGaffe",
                "Clément",
                new GregorianCalendar(2004, Calendar.MARCH, 15).getTime(),
                "Rue de la pierre",
                Sexe.HOMME,
                "34501",
                0,
                new GregorianCalendar(2022, Calendar.DECEMBER, 2).getTime(),
                new GregorianCalendar(2023, Calendar.DECEMBER, 2).getTime()
        );

        clientAboRepository.save(clement);
        ClientAbonne subscriber = clientAboRepository.isSubscriber("34501", "1234 2345 2345 9999");
        assertThat(subscriber.getNom()).isEqualTo(clement.getNom());

    }

}

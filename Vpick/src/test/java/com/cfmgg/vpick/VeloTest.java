package com.cfmgg.vpick;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repositories.BornetteRepository;
import com.cfmgg.vpick.repositories.VeloRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VeloTest {
    @Autowired
    VeloRepository veloRepository;

    @Autowired
    BornetteRepository bornetteRepository;

    /**
     * Doit pouvoir retrouver un vélo associé à une bornette
     */
    @Test
    void shouldSaveVelo(){


        LocalDate start = LocalDate.of(2015, Month.OCTOBER, 14);
        LocalDate end = LocalDate.now();
        LocalDate random = between(start, end);
        Date date = Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Velo velo = new Velo(date, Etat.OK, StatusVelo.LIBRE, null);

        veloRepository.save(velo);
        Bornette bornette = new Bornette(999, Etat.OK, velo);

        bornetteRepository.save(bornette);
        Velo veloFound = veloRepository.getVeloByBornetteId(bornette.getId());

        assertThat(veloFound.getId()).isEqualTo(velo.getId());

    }

    /**
     * Generate a random date
     */
    public static @NotNull LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}

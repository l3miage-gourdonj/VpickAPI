package com.cfmgg.vpick;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.ClientNonAbonne;
import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repositories.LocationRepository;
import com.cfmgg.vpick.repositories.VeloRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LocationTest {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    VeloRepository veloRepository;


    @Test
    public void shouldSaveClientNonAbonneLocation(){
        LocalDate start = LocalDate.of(2015, Month.OCTOBER, 14);
        LocalDate end = LocalDate.now();
        LocalDate random = between(start, end);
        // pierre = new ClientNonAbonne("1234 2345 1234 1223");
        Date startDate = Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date endDate = Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());

        StatusVelo statusVelo = StatusVelo.LIBRE;

        Date date = Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Velo velo = new Velo(date, Etat.OK, statusVelo, null);

        veloRepository.save(velo);
        Location location = new Location(List.of(velo), null, startDate, null, "55555");

        locationRepository.save(location);
        Location locationFound = locationRepository.getLocationNonAboByCodeSecret("55555");
        assertThat(locationFound.getId()).isEqualTo(location.getId());
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

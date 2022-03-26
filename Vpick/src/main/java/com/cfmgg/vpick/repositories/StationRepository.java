package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Ici on met les requetes lié a une station
 */
public interface StationRepository extends JpaRepository<Station, Long> {

    /**
     * Recupere la liste des stations possedant au moin nbLocation
     * emplacement de libre afin de ramener une location
     * @param nbLocations le nombre de location que l'on veux deposer
     * @return La liste des stations
     */
    @Query(value =
            "select * from station where station.id in" +
            " (select station_bornettes.station_id from station_bornettes join bornette on station_bornettes.bornettes_id = bornette.id" +
            " where bornette.velo_id is null" +
            " group by station_bornettes.station_id" +
            " having count(bornette.id)>=:nbLocations)",nativeQuery = true)
    List<Station> getStationLibres(@Param("nbLocations") int nbLocations);
    //select * from station where id IN
    //          (select station_id from station_bornettes
    //              where bornettes_id IN (select id from bornette where velo_id = null)
    //              Group by station_id
    //              Having count bornettes_id > :limite
}

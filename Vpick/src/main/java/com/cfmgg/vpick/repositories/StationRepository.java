package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    @Query(value =
            " select * from station where id IN" +
            " (select station_id from station_bornettes natural join bornette" +
            " where velo_id is null and etat = 0" +
            " Group by station_id" +
            " Having count(bornettes_id) >= :nbLocations)",nativeQuery = true)
    List<Station> getStationLibres(@Param("nbLocations") int nbLocations);
    //select * from station where id IN
    //          (select station_id from station_bornettes
    //              where bornettes_id IN (select id from bornette where velo_id = null)
    //              Group by station_id
    //              Having count bornettes_id > :limite
}

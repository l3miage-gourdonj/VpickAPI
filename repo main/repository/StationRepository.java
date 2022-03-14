package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>{
//On ne considere que les bornettes 'OK'
    @Query("select s from Station s")
    List<Station> findStationByStatusWithAvailableBike(StatusStation statusStation);

    List<Station> findStationByStatusWithFreeBornette(StatusStation statusStation);

    List<Station> findStationWithAvailableBike(StatusStation statusStation);

    List<Station> findStationWithFreeBornette(StatusStation statusStation);

}

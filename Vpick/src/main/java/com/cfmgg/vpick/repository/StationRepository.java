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
    @Query("select s from Station s where s.id = :id")
    Station findStationById(@Param("id") Long id);


    @Query("select s from Station s where s.adresse like '%:adresse%'")
    List<Station> findStationByAdresse(@Param("adresse") String adresse);

    @Query("select s from Station s where s.status = :statusStation ")
    List<Station> findStationByStatus(@Param("statusStation") StatusStation statusStation);
}

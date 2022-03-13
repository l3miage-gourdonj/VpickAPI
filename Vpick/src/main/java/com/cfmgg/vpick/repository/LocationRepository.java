package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("select l from Location l where l.client.id = :id")
    List<Location> findLocationByClient(@Param("id") Long id);

    @Query("select l from Location l where l.id = :id")
    Location findLocationById(@Param("id") Long id);


    @Query(value = "select v from velo v NATURAL JOIN location_velo l where l.location_id = :id", nativeQuery = true)
    List<Velo> findVeloLocationById(@Param("id") Long id);

    @Query("select l from Location l where l.dateFin IS NULL")
    List<Location> checkIfCodeSecretExist();
}

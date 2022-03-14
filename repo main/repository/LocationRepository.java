package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("select l from Location l where l.client.id = :id")
    List<Location> findLocationByClient(@Param("id") Long id);

}

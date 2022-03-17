package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}

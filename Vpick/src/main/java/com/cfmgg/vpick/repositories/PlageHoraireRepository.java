package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.PlageHoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlageHoraireRepository extends JpaRepository<PlageHoraire,Long> {
}

package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BornetteRepository extends JpaRepository<Bornette, Long> {


    @Query("select b from Bornette b where b.id = :id")
    Bornette findBornetteById(@Param("id") Long id);

    @Query("select b from Bornette b where b.station.adresse = :adresse")
    List<Bornette> findBornetteByStationAdresse(@Param("adresse")String adresse);

    @Query("select b from Bornette b where b.etat = :etat")
    List<Bornette> findBornetteByEtat(@Param("etat")Etat etat);

    @Query("select b from Bornette b where b.etat = :etat and b.station.adresse = :adresse")
    List<Bornette> findBornetteByStationAdresseAndEtat(@Param("adresse")String adresse, @Param("etat")Etat etat);

    @Query("select v from Velo v where v.bornette = :bornetteId")
    Velo findVeloFromBornetteId(@Param("bornetteId")Long bornetteId);

}

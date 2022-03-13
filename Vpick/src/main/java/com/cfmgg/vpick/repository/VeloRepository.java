package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface VeloRepository extends JpaRepository<Velo, Long> {


    @Query("select v from Velo v where v.id=:id")
    Velo findVeloById(@Param("id") Long id);

    @Query("select v from Velo v where v.modele.modele=:modele")
    Velo findVeloByModele(@Param("modele") String modele);

    @Query("select v from Velo v where v.bornette.id=:id")
    Velo findVeloByBornette(@Param("id") Long id);

    @Query("select v from Velo v where v.status=:status")
    List<Velo> findVeloByStatus(@Param("status") StatusVelo statusVelo);

    @Query("select v from Velo v where v.etat=:etat")
    List<Velo> findVeloByEtat(@Param("etat") Etat etat);

    @Query("select v from Velo v where v.dateMiseEnService=:dateMiseEnService")
    List<Velo> findVeloByDateMiseEnService( @Param("dateMiseEnService") Date dateMiseEnService);

    @Transactional
    @Modifying
    @Query(value = "update velo v set v.status = :status where v.id = :id", nativeQuery = true)
    void updateStatusVelo(@Param("status") StatusVelo status,@Param("id") Long id);

}

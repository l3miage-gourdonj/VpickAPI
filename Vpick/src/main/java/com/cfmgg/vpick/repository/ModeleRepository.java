package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long> {
    @Query("select m from Modele m where m.id = :id")
    Modele findModeleById(@Param("id") Long id);
    @Query("select m from Modele m where m.modele = :modele")
    Modele findModeleByModele(@Param("modele") String modele);
    @Query("select m from Modele m where m.coutHoraire = :coutHoraire")
    List<Modele> findModeleByCoutHoraire(@Param("coutHoraire") Float coutHoraire);

}

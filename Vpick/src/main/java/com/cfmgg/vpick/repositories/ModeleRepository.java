package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * ici les requetes lie au modele de velo
 */
public interface ModeleRepository extends JpaRepository<Modele, Long> {

    /**
     * recupere le modele d'id id
     * @param id l'id du modele rechercher
     * @return le modele trouver s'il existe
     */
    @Query("select m from Modele m where m.id = :id")
    Modele findModeleById(@Param("id") Long id);

    /**
     * recupere le modele par son nom
     * @param modele le nom du modele rechercher
     * @return le modele rechercher s'il existe
     */
    @Query("select m from Modele m where m.modele = :modele")
    Modele findModeleByModele(@Param("modele") String modele);

    /**
     * recupere la liste de tout les modele ayant un cout horaire de coutHoraire
     * @param coutHoraire le cout horaire rechercher
     * @return la liste des modele correspondant a la demande
     */
    @Query("select m from Modele m where m.coutHoraire >= :coutHoraire")
    List<Modele> findModeleByCoutHoraire(@Param("coutHoraire") Float coutHoraire);

}

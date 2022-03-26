package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * ici on creer tout les requete lier a un velo
 */
public interface VeloRepository extends JpaRepository<Velo, Long> {

    /**
     * recupere le velo actuellement sur la bornette d'id id
     * @param id l'id de la bornette
     * @return le Velo lié s'il existe
     */
    @Query("select v from Velo v join Bornette b on b.velo = v where b.id=:id")
    public Velo getVeloByBornetteId(Long id);
}

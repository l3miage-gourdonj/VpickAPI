package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Ici les requetes lié aux locations de client abonne ou non
 */
public interface LocationRepository extends JpaRepository<Location,Long> {

    /**
     * permet de savoir si un code secret et deja utiliser par une autre location actuellement en cour n'ayant pas de client lié
     * @param codeSecret le code secret a chercher
     * @return true si le code existe deja false sinon
     */
    boolean existsBycodeSecretAndDateFinIsNullAndClientIsNull(String codeSecret);

    /**
     *  recupere la location d'un clien non abonné actuellement en court grace au code secret lié
     * @param codeSecret le code secret de la location rechercher
     * @return la location trouver si elle existe
     */
    @Query("select l from Location l where l.codeSecret = :code and l.client is null and l.dateFin is null")
    Location getLocationNonAboByCodeSecret(@Param("code") String codeSecret);

    /**
     * recupere la liste des location en cours du client abonne ayant pour code secret code secret et pour cb cb
     * @param codeSecret le code secret du client abonne
     * @param cb la cb du client abonne
     * @return la liste des location trouver
     */
    @Query(value=" select l.* from location l where l.code_secret = :code and l.date_fin is null and l.client_id in (select c.id from client c, client_abonne ca  where ca.code_secret = :code and c.carte_bancaire= :cb)" , nativeQuery=true)
    List<Location> getLocationAbo(@Param("code") String codeSecret,@Param("cb") String cb);
}

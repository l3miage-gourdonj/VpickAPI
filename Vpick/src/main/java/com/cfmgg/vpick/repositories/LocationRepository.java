package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    boolean existsBycodeSecretAndDateFinIsNullAndClientIsNull(String codeSecret);
    @Query("select l from Location l where l.codeSecret = :code and l.client is null and l.dateFin is null")
    Location getLocationNonAboByCodeSecret(@Param("code") String codeSecret);

    @Query(value=" select l.* from location l where l.code_secret = :code and l.date_fin is null and l.client_id in (select c.id from client c, client_abonne ca  where ca.code_secret = :code and c.carte_bancaire= :cb)" , nativeQuery=true)
    List<Location> getLocationAbo(@Param("code") String codeSecret,@Param("cb") String cb);
}

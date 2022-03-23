package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    boolean existsBycodeSecretAndDateFinIsNullAndClientIsNull(String codeSecret);
    @Query("select l from Location l where l.codeSecret = :code and l.client is null and l.dateFin is null")
    Location getLocationNonAboByCodeSecret(@Param("code") String codeSecret);
}

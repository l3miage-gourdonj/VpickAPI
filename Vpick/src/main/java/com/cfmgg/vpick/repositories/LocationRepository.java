package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    boolean existsBycodeSecretAndDateFinIsNullAndClientIsNull(String codeSecret);
}

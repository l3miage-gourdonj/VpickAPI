package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.ClientNonAbonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientNonAboRepository extends JpaRepository<ClientNonAbonne,Long> {


}

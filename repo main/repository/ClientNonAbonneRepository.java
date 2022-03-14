package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientNonAbonneRepository extends JpaRepository<Client, Long> {

}

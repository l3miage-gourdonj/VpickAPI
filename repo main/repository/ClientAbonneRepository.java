package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientAbonneRepository extends JpaRepository<ClientAbonne, Long> {

    //login
}

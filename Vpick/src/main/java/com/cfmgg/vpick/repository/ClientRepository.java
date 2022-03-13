package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.id = :id")
    Client findClientById(@Param("id") Long id);

    @Query("select c from Client c where c.carteBancaire like :cb")
    Client findClientByCB(@Param("cb") String cb);

    @Query("select ca from ClientAbonne ca where ca.codeSecret like :codeSecret")
    ClientAbonne findClientByCodeSecret(@Param("codeSecret") String codeSecret);

    @Query(value = "select * from client where dtype like 'CA'", nativeQuery = true)
    List<ClientAbonne> findAllClientAbonne();

    @Query(value = "select * from client where dtype like 'Client'", nativeQuery = true)
    List<Client> findAllClientNonAbonne();

}

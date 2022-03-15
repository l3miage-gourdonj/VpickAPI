package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAboRepository extends JpaRepository<Client, Long> {

    @Query("select ca from ClientAbonne ca where ca.codeSecret = :codeSecret and ca.carteBancaire Like :carteBancaire")
    Client isSubscriber(@Param("codeSecret") String codeSecret, @Param("carteBancaire") String carteBancaire);
    //
}

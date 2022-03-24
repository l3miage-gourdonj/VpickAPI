package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAboRepository extends JpaRepository<Client, Long> {

    @Query("select ca from ClientAbonne ca where ca.codeSecret = :codeSecret and ca.carteBancaire Like :carteBancaire")
    ClientAbonne isSubscriber(@Param("codeSecret") String codeSecret, @Param("carteBancaire") String carteBancaire);
    //select * from client c join client_abonne ca on ca.id=c.id where ca.date_fin_abonnement>NOW() and ca.code_secret = '12345' and c.carte_bancaire='1234 2345 2345 8793'

    @Query("select count(ca.id) = 1 from ClientAbonne ca where ca.codeSecret = :codeSecret and ca.carteBancaire Like :carteBancaire")
    boolean notSubscribe(@Param("codeSecret") String codeSecret, @Param("carteBancaire") String carteBancaire);
}

package com.cfmgg.vpick.repository;


import com.cfmgg.vpick.models.Bornette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BornetteRepository extends JpaRepository<Bornette, Long> {}

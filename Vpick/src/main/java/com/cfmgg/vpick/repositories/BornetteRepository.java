package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Bornette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BornetteRepository extends JpaRepository<Bornette,Long> {
    Bornette findBornetteById(long id);
}

package com.cfmgg.vpick.repositories;

import com.cfmgg.vpick.models.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeloRepository extends JpaRepository<Velo, Long> {

    @Query("select v from Velo v join Bornette b on b.velo = v where b.id=:id")
    public List<Velo> getListVeloByBornetteId(Long id);
}

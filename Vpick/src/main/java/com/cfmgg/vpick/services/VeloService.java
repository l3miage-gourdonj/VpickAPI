package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repositories.VeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeloService {

    private final VeloRepository veloRepository;

    @Autowired
    public VeloService(VeloRepository veloRepository) {
        this.veloRepository = veloRepository;
    }

    public List<Velo> getListVeloByBornetteId(Long id){
        return veloRepository.getListVeloByBornetteId(id);
    }
}

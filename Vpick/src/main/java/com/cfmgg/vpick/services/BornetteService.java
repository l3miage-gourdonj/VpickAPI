package com.cfmgg.vpick.services;

import com.cfmgg.vpick.repositories.BornetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BornetteService {

    private final BornetteRepository bornetteRepository;

    @Autowired
    public BornetteService(BornetteRepository bornetteRepository) {
        this.bornetteRepository = bornetteRepository;
    }

}

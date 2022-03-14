package com.cfmgg.vpick.services;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repository.BornetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record BornetteService(BornetteRepository bornetteRepository) {

    @Autowired
    public BornetteService (BornetteRepository bornetteRepository){
        this.bornetteRepository = bornetteRepository;
    }

    public Bornette findBornetteById(Long id) {
        return bornetteRepository.findBornetteById(id);
    }

    public List<Bornette> findBornetteByStationAdresse(String adresse) {
        return bornetteRepository.findBornetteByStationAdresse(adresse);
    }

    public List<Bornette> findBornetteByEtat(Etat etat) {
        return bornetteRepository.findBornetteByEtat(etat);
    }

    public List<Bornette> findBornetteByStationAdresseAndEtat(String adresse, Etat etat) {
        return bornetteRepository.findBornetteByStationAdresseAndEtat(adresse, etat);
    }

    public Velo findVeloFromBornetteId(Long bornetteId) {
        return bornetteRepository.findVeloFromBornetteId(bornetteId);
    }

    public List<Bornette> findAllBornettes() {
        return bornetteRepository.findAll();
    }

    public void registerNewBornette(Bornette bornette) {
        bornetteRepository.save(bornette);
    }
}

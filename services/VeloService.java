package com.cfmgg.vpick.services;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repository.VeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VeloService {

    private final VeloRepository veloRepository;

    @Autowired
    public VeloService(VeloRepository veloRepository) {
        this.veloRepository = veloRepository;
    }

    public Velo findVeloById(Long id) {
        return veloRepository.findVeloById(id);
    }

    public Velo findVeloByModele(String modele) {
        return veloRepository.findVeloByModele(modele);
    }

    public Velo findeVeloByBornette(Long id){
        return veloRepository.findVeloByBornette(id);
    }

    public List<Velo> findVeloByStatus(StatusVelo statusVelo) {
        return veloRepository.findVeloByStatus(statusVelo);
    }

    public List<Velo> findVeloByEtat(Etat etat){
        return veloRepository.findVeloByEtat(etat);
    }

    public List<Velo> findVeloByDateMiseEnService(Date dateMiseEnService){
        return veloRepository.findVeloByDateMiseEnService(dateMiseEnService);
    }

    public List<Velo> findAllVelo(){
        return veloRepository.findAll();
    }

    public void registerNewVelo(Velo velo){
        veloRepository.save(velo);
    }

    public void updateStatusVelo(StatusVelo status ,Long id){ veloRepository.updateStatusVelo(status,id);}
}

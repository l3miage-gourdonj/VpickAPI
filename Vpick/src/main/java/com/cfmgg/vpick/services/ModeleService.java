package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.repositories.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {

    private final ModeleRepository modeleRepository;
    @Autowired
    public ModeleService(ModeleRepository modeleRepository){
        this.modeleRepository = modeleRepository;
    }

    public Modele findModeleById(Long id){
        return modeleRepository.findModeleById(id);
    }

    public Modele findModeleByModele(String modele){
        return modeleRepository.findModeleByModele(modele);
    }

    public List<Modele> findModeleByCoutHoraire(Float coutHoraire){
        return modeleRepository.findModeleByCoutHoraire(coutHoraire);
    }

    public List<Modele> listModele(){
        return modeleRepository.findAll();
    }

    public void registerNewModele(Modele modele){
        modeleRepository.save(modele);
    }

}

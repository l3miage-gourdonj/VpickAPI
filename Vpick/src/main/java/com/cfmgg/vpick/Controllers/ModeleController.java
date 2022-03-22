package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.services.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/modeles")
public class ModeleController {
    private final ModeleService modeleService;

    @Autowired
    public ModeleController(ModeleService modeleService) {
        this.modeleService = modeleService;
    }

    @GetMapping
    public List<Modele> listModeles(){
        return modeleService.listModele();
    }

    @RequestMapping(value = "/get/coutHoraire/{coutHoraire}", method = RequestMethod.GET)
    public List<Modele> findModeleByCoutHoraire(@PathVariable("coutHoraire")Float coutHoraire){
        return modeleService.findModeleByCoutHoraire(coutHoraire);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Modele findModeleByCoutHoraire(@PathVariable("id")Long id){
        return modeleService.findModeleById(id);
    }
    @RequestMapping(value = "/get/modele/{modele}", method = RequestMethod.GET)
    public Modele findModeleByCoutHoraire(@PathVariable("modele")String modele){
        return modeleService.findModeleByModele(modele);
    }

    @PostMapping
    public void registerNewModele(@RequestBody Modele modele){
        modeleService.registerNewModele(modele);
    }

}

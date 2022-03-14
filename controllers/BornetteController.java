package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.services.BornetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/bornettes")
public class BornetteController {
    private final BornetteService bornetteService;
    @Autowired
    public BornetteController(BornetteService bornetteService) {
        this.bornetteService = bornetteService;
    }
    @GetMapping
    public List<Bornette> findAllBornettes(){
        return bornetteService.findAllBornettes();
    }

    @PostMapping
    public void registerNewBornette(Bornette bornette){
        bornetteService.registerNewBornette(bornette);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Bornette findBornetteById(@PathVariable("id") Long id) {
        return bornetteService.findBornetteById(id);
    }

    @RequestMapping(value = "/get/adresse/{adresse}", method = RequestMethod.GET)
    public List<Bornette> findBornetteByStationAdresse(@PathVariable("adresse") String adresse) {
        return bornetteService.findBornetteByStationAdresse(adresse);
    }

    @RequestMapping(value = "/get/etat/{etat}", method = RequestMethod.GET)
    public List<Bornette> findBornetteByEtat(@PathVariable("etat") Etat etat) {
        return bornetteService.findBornetteByEtat(etat);
    }

    @RequestMapping(value = "/get/adresse/{adresse}/etat/{etat}", method = RequestMethod.GET)
    public List<Bornette> findBornetteByStationAdresseAndEtat(@PathVariable("adresse") String adresse,@PathVariable("etat") Etat etat) {
        return bornetteService.findBornetteByStationAdresseAndEtat(adresse,etat);
    }

    @RequestMapping(value = "/get/velo/{id}", method = RequestMethod.GET)
    public Velo findVeloFromBornetteId(@PathVariable("id") Long id) {
        return bornetteService.findVeloFromBornetteId(id);
    }



}

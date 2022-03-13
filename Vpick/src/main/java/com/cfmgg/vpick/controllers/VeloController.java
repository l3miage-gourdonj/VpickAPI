package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.services.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/velos")
public class VeloController {

    private final VeloService veloService;

    @Autowired
    public VeloController(VeloService veloService) {
        this.veloService = veloService;
    }

    @GetMapping
    public List<Velo> findAllVelo(){
        return veloService.findAllVelo();
    }

    @PostMapping(value="/new")
    public void registerNewVelo(Velo velo){
        veloService.registerNewVelo(velo);
    }

    @RequestMapping(value = "/update/id/{id}/status/{status}", method = RequestMethod.POST)
    public void updateStatusVelo(@PathVariable("status") StatusVelo status,@PathVariable("id") Long id){veloService.updateStatusVelo(status,id);}

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Velo findVeloById(@PathVariable("id") Long id){
        return veloService.findVeloById(id);
    }

    @RequestMapping(value = "/get/modele/{modele}", method = RequestMethod.GET)
    public Velo findVeloByModele(@PathVariable("modele") String modele){
        return veloService.findVeloByModele(modele);
    }

    @RequestMapping(value = "/get/bornette/{id}", method = RequestMethod.GET)
    public Velo findVeloByBornette(@PathVariable("id") Long id){
        return veloService.findeVeloByBornette(id);
    }

    @RequestMapping(value = "/get/status/{statusVelo}", method = RequestMethod.GET)
    public List<Velo> findVeloByStatus(@PathVariable("statusVelo") StatusVelo statusVelo){
        return veloService.findVeloByStatus(statusVelo);
    }

    @RequestMapping(value = "/get/etat/{etat}", method = RequestMethod.GET)
    public List<Velo> findVeloByEtat(@PathVariable("etat") Etat etat){
        return veloService.findVeloByEtat(etat);
    }

    @RequestMapping(value = "/get/date/{date}", method = RequestMethod.GET)
    public List<Velo> findVeloByDateMiseEnService(@PathVariable("date") Date date){
        return veloService.findVeloByDateMiseEnService(date);
    }
}

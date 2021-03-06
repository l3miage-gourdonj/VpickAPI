package com.cfmgg.vpick.controllers;


import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.services.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * genere et gere les requetes http que l'on utilise sur le site afin de communiquer avec notre api et notre base de donnée
 */
@RestController
@RequestMapping(value = "/api/vpick/velo")
public class VeloController {

    private final VeloService veloService;

    @Autowired
    public VeloController(VeloService veloService) {
        this.veloService = veloService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/bornette/{id}",method = RequestMethod.GET)
    public Velo getListVeloByBornetteId(@PathVariable("id")Long id){
        return veloService.getListVeloByBornetteId(id);
    }
}

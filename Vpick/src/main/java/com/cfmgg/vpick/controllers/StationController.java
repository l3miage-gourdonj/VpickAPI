package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/vpick/station")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Autowired

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Station> getAllStations(){
        return stationService.getAllStations();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/nb/{nbLocations}",method = RequestMethod.GET)
    public List<Station> getStationsLibres(@PathVariable("nbLocations") int nbLocations){
        return stationService.getStationsLibres(nbLocations);
    }
}

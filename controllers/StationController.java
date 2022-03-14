package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.enums.StatusStation;
import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/stations")
public class StationController {


    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public List<Station> getStation(){
        return stationService.getListStations();
    }

    @RequestMapping(value = "/get/adresse/{adresse}", method = RequestMethod.GET)
    public List<Station> getStationByAdresse(@PathVariable String adresse){
            return stationService.getStationByAdresse(adresse);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Station getStationById(@PathVariable Long id){
        return stationService.getStationById(id);
    }

    @RequestMapping(value = "/get/status/{statusStation}", method = RequestMethod.GET)
    public List<Station> findStationByStatus(@PathVariable StatusStation statusStation){
        return stationService.findStationByStatus(statusStation);
    }

    @PostMapping
    public void registerNewStation(@RequestBody Station station){
        stationService.registerNewStation(station);
    }

}

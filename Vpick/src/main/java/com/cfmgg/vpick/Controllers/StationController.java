package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.models.Station;
import com.cfmgg.vpick.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

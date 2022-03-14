package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> findAllLocation(){
        return locationService.findAllLocation();
    }

    @PostMapping
    public void registerNewLocation(Location location){
        locationService.registerNewLocation(location);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Location findLocationById(@PathVariable("id") Long id){
        return locationService.findLocationById(id);
    }

    @RequestMapping(value = "/get/client/{id}", method = RequestMethod.GET)
    public List<Location> findLocationByClient(@PathVariable("id") Long id){
        return locationService.findLocationByClient(id);
    }

    @RequestMapping(value = "/get/velo/{id}", method = RequestMethod.GET)
    public List<Velo> findVeloLocationById(@PathVariable("id") Long id){
        return locationService.findVeloLocationById(id);
    }

    @RequestMapping(value = "/get/codeSecret/{codeSecret}", method = RequestMethod.GET)
    public Boolean checkIfCodeSecretExist(@PathVariable("codeSecret") String codeSecret){
        return locationService.checkIfCodeSecretExist(codeSecret);
    }
}

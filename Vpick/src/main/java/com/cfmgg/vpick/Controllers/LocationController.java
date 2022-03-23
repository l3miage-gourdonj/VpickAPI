package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/vpick/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @CrossOrigin(value = "http://localhost:4200/")
    @PostMapping
    public @ResponseBody String registerLocation(@RequestBody String json){
        return locationService.registerLocation(json);
    }
}
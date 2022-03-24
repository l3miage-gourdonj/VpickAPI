package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(value = "http://localhost:4200/")
    @RequestMapping(value="/code/{codeSecret}",method = RequestMethod.GET)
    public Location getLocationNonAbo(@PathVariable("codeSecret") String codeSecret){
        return locationService.getLocationNonAbo(codeSecret);
    }

    @CrossOrigin(value = "http://localhost:4200/")
    @RequestMapping(value="/cb/{cb}/code/{code}",method = RequestMethod.GET)
    public List<Location>  getLocationAbo(@PathVariable("code") String codeSecret,@PathVariable("cb")String cb){
        return locationService.getLocationAbo(codeSecret,cb);
    }

    @CrossOrigin(value = "http://localhost:4200/")
    @RequestMapping(value="/retour",method = RequestMethod.POST)
    public @ResponseBody boolean retourLocation(@RequestBody String json){
        return locationService.retourLocation(json);
    }

}

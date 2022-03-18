package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.services.BornetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vpick/bornette")
public class BornetteController {

    private final BornetteService bornetteService;

    @Autowired
    public BornetteController(BornetteService bornetteService) {
        this.bornetteService = bornetteService;
    }


    @CrossOrigin(origins = "http://localhost:4200/bringBack")
    @RequestMapping(value="/id={id}")
    public List<Bornette> getFreeBornette(@PathVariable("id") Long id){
        return bornetteService.getFreeBornette(id);
    }
}

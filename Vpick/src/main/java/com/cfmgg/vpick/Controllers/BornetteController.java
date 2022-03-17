package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.services.BornetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/vpick/bornette")
public class BornetteController {

    private final BornetteService bornetteService;

    @Autowired
    public BornetteController(BornetteService bornetteService) {
        this.bornetteService = bornetteService;
    }
}

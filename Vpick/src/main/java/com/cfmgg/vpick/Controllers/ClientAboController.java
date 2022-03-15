package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.services.ClientAboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vpick/abo")
public class ClientAboController {

    private final ClientAboService clientAboService;

    @Autowired
    public ClientAboController(ClientAboService clientAboService) {
        this.clientAboService = clientAboService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "cb/{carteBancaire}/code/{codeSecret}", method = RequestMethod.GET)
    public Client isSubscriber(@PathVariable("codeSecret") String codeSecret, @PathVariable("carteBancaire") String carteBancaire){
        return clientAboService.isSubscriber(codeSecret,carteBancaire);
    }
}

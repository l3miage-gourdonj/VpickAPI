package com.cfmgg.vpick.controllers;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import com.cfmgg.vpick.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="vpick/v0/clients")
public class ClientController {


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> listClient(){
        return clientService.listClient();
    }


    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public Client findClientById(@PathVariable("id") Long id){
        return clientService.findClientById(id);
    }

    @RequestMapping(value = "/get/cb/{carte_bancaire}", method = RequestMethod.GET)
    public Client findClientByCB(@PathVariable("carte_bancaire") String cb){
        return clientService.findClientByCB(cb);
    }


    @RequestMapping(value ="/get/codeSecret/{code_secret}", method = RequestMethod.GET)
    public ClientAbonne findClientByCodeSecret(@PathVariable("code_secret") String codeSecret){
        return clientService.findClientByCodeSecret(codeSecret);
    }

    @GetMapping(value = "/clientAbo")
    public List<ClientAbonne> findAllClientAbonne(){
        return clientService.findAllClientAbonne();
    }

    @GetMapping(value = "/clientNAbo")
    public List<Client> findAllClientNonAbonne(){
        return clientService.findAllClientNonAbonne();
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.registerNewClient(client);
    }


}

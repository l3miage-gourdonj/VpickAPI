package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import com.cfmgg.vpick.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> listClient(){
        return clientRepository.findAll();
    }

    public Client findClientById(Long id){
        return clientRepository.findClientById(id);
    }

    public void registerNewClient(Client client){
        clientRepository.save(client);
    }

    public Client findClientByCB(String cb){
        return clientRepository.findClientByCB(cb);
    }

    public ClientAbonne findClientByCodeSecret(String codeSecret){
        return clientRepository.findClientByCodeSecret(codeSecret);
    }

    public List<ClientAbonne> findAllClientAbonne(){
        return clientRepository.findAllClientAbonne();
    }

    public List<Client> findAllClientNonAbonne(){
        return clientRepository.findAllClientNonAbonne();
    }

}

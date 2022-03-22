package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.repositories.ClientAboRepository;

import com.cfmgg.vpick.models.ClientAbonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientAboService {

    private final ClientAboRepository clientAboRepository;

    @Autowired
    public ClientAboService(ClientAboRepository clientAboRepository){
        this.clientAboRepository = clientAboRepository;
    }

    public ClientAbonne isSubscriber(String codeSecret, String carteBancaire){
        return clientAboRepository.isSubscriber(codeSecret,carteBancaire);
    }

    public void newSubscriber(ClientAbonne client) {
        clientAboRepository.save(client);
    }
}

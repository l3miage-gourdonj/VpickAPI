package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientAboService {

    private final ClientAboRepository clientAboRepository;

    @Autowired
    public ClientAboService(ClientAboRepository clientAboRepository){
        this.clientAboRepository = clientAboRepository;
    }

    public Client isSubscriber(String codeSecret, String carteBancaire){
        return clientAboRepository.isSubscriber(codeSecret,carteBancaire);
    }
}

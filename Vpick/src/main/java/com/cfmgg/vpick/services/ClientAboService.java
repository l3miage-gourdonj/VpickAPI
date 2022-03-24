package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.repositories.ClientAboRepository;

import com.cfmgg.vpick.models.ClientAbonne;
import org.json.JSONObject;
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

    public boolean notSubscribe(String codeSecret, String carteBancaire){
        return !clientAboRepository.notSubscribe(codeSecret, carteBancaire);
    }

    public void updateClient(ClientAbonne clientAbo) {
        clientAboRepository.save(clientAbo);
    }

    public void updateCreditTemps(String client) {
        JSONObject json = new JSONObject(client);
        String codeSecret;
        String cb;
        int credit;
        if(json.has("creditsTemps") && json.has("cb") && json.has("code")){
            codeSecret = json.getString("code");
            cb = json.getString("cb");
            credit = json.getInt("creditsTemps");
            ClientAbonne clientAbo = clientAboRepository.isSubscriber(codeSecret,cb);
            clientAbo.setCreditTemps(clientAbo.getCreditTemps()+credit);
            clientAboRepository.save(clientAbo);
        }

    }
}

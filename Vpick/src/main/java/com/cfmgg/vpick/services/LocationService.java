package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.*;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import com.cfmgg.vpick.repositories.ClientNonAboRepository;
import com.cfmgg.vpick.repositories.LocationRepository;
import com.cfmgg.vpick.repositories.VeloRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final ClientAboRepository clientAboRepository;
    private final VeloRepository veloRepository;
    private final ClientNonAboRepository clientNonAboRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, ClientAboRepository clientAboRepository, VeloRepository veloRepository ,ClientNonAboRepository clientNonAboRepository) {
        this.locationRepository = locationRepository;
        this.clientAboRepository = clientAboRepository;
        this.veloRepository = veloRepository;
        this.clientNonAboRepository = clientNonAboRepository;
    }

    public String saveLocation(String location) throws JSONException {
        System.out.println(location);
        JSONObject obj = new JSONObject(location);
        String codeRetour = null;
        String codeSecret= "12354";
        String cb ="1234 2345 2345 8793";
        JSONArray bornettes=null;
        if(obj.has("codeClient")){
            codeSecret = obj.getString("codeClient");
        }
        if(obj.has("carteBanquaire")){
            cb = obj.getString("carteBanquaire");
        }
        if(obj.has("bornettes")){
            bornettes = obj.getJSONArray("bornettes");
        }
        System.out.println("code secret : "+ codeSecret);
        System.out.println("cb : "+cb);
        System.out.println("bornettes : "+bornettes);
        List<Velo> velos = new ArrayList<Velo>();
        Client client = null;
        if(cb!=null && codeSecret!=null && bornettes!=null){
            System.out.println("okok");
            client = clientAboRepository.isSubscriber(codeSecret,cb);
            System.out.println(client);
        }else if(cb!=null && bornettes!=null){
            /*
            Cette partie est a revoir car pas logique on a pas la cb pour un non abo devrait juste avoir le code secret
             */
            ClientNonAbonne c = new ClientNonAbonne(cb);
            codeSecret = ""+(int) ((Math.random() * (99999 - 10000)) + 10000);
            while(clientAboRepository.existsBycodeSecret(codeSecret)&& locationRepository.existsByCodeSecret(codeSecret)){
                codeSecret = ""+(int) ((Math.random() * (99999 - 10000)) + 10000);
            }
            clientNonAboRepository.save(c);
            client = c;
        }
        System.out.println("cest good");
        if(client != null && bornettes != null) {
            for (int i = 0; i < bornettes.length(); i++) {
                velos.add(veloRepository.getListVeloByBornetteId(bornettes.getLong(i)));
            }
            System.out.println("ca passe ouais");
            Location nvLocation = new Location(velos, client,new GregorianCalendar().getTime(),null,codeSecret);
            locationRepository.save(nvLocation);
        }
        return codeRetour;
    }
}

/*
location = location.replace('"',' ');
        location =location.replace('[',' ');
        location =location.replace(']',' ');
        String[] json = location.split("[,:]");
        for (String j: json) {
            System.out.println(j);
        }
 */

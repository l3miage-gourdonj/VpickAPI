package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repositories.ClientAboRepository;
import com.cfmgg.vpick.repositories.LocationRepository;
import com.cfmgg.vpick.repositories.VeloRepository;
import org.json.JSONArray;
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

    @Autowired
    public LocationService(LocationRepository locationRepository,ClientAboRepository clientAboRepository,VeloRepository veloRepository) {
        this.locationRepository = locationRepository;
        this.clientAboRepository = clientAboRepository;
        this.veloRepository = veloRepository;
    }

    public String registerLocation(String json){
        String codeLocation = null;
        JSONObject jsonObject = new JSONObject(json);
        String codeSecret = null;
        String cb = null;
        JSONArray bornettes = null;
        Client client = null;
        if(jsonObject.has("codeSecret")){
            codeSecret = jsonObject.getString("codeSecret");
        }
        if(jsonObject.has("carteBancaire")){
            cb = jsonObject.getString("carteBancaire");
        }
        if(jsonObject.has("bornettes")){
            bornettes = jsonObject.getJSONArray("bornettes");
        }
        if(codeSecret!=null && cb != null){
            client = clientAboRepository.isSubscriber(codeSecret,cb);
        }else{
            codeSecret = ""+(int) ((Math.random() * (99999 - 10000)) + 10000);
            while(locationRepository.existsBycodeSecretAndDateFinIsNullAndClientIsNull(codeSecret)){
                codeSecret = ""+(int) ((Math.random() * (99999 - 10000)) + 10000);
            }
            codeLocation = codeSecret;
        }
        List<Velo> velos = new ArrayList<>();
        if(bornettes.length()!=0) {
            for (int i = 0; i < bornettes.length(); i++) {
                velos.add(veloRepository.getVeloByBornetteId(bornettes.getLong(i)));
            }
            Location location = new Location(velos,client,new GregorianCalendar().getTime(),null,codeSecret);
            locationRepository.save(location);
        }
        return codeLocation;
    }
}

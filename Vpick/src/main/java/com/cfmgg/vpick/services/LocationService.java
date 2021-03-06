package com.cfmgg.vpick.services;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.models.Bornette;
import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repositories.BornetteRepository;
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
import java.util.Optional;


@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final ClientAboRepository clientAboRepository;
    private final VeloRepository veloRepository;
    private final BornetteRepository bornetteRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository,ClientAboRepository clientAboRepository,VeloRepository veloRepository,BornetteRepository bornetteRepository) {
        this.locationRepository = locationRepository;
        this.clientAboRepository = clientAboRepository;
        this.veloRepository = veloRepository;
        this.bornetteRepository = bornetteRepository;
    }

    /**
     * Transforme les information d'un client et d'un location fournis en json en un object location enregistrer dans la base
     * update les bornettes concerner pour enlever le velo
     * et genere un code random qui n'est pas en cours d'utilisation si le client est non abonner
     * @param json le json contenant les informations
     * @return le code secret lier a la location
     */
    public String registerLocation(String json){
        System.out.println("json : "+json);
        String codeLocation = null;
        JSONObject jsonObject = new JSONObject(json);
        String codeSecret = null;
        String cb = null;
        JSONArray bornettes = null;
        Client client = null;
        if(jsonObject.has("codeClient")){
            codeSecret = jsonObject.getString("codeClient");
        }
        if(jsonObject.has("cbClient")){
            cb = jsonObject.getString("cbClient");
        }
        if(jsonObject.has("bornettes")){
            bornettes = jsonObject.getJSONArray("bornettes");
        }
        if(codeSecret!=null && cb != null){
            client = clientAboRepository.isSubscriber(codeSecret,cb);
            codeLocation = codeSecret;
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
                Bornette bornette = bornetteRepository.findBornetteById(bornettes.getLong(i));
                System.out.println(bornettes.getLong(i));
                bornette.setVelo(null);
                bornetteRepository.save(bornette);
            }
            Location location = new Location(velos,client,new GregorianCalendar().getTime(),null,codeSecret);
            locationRepository.save(location);
        }
        return codeLocation;
    }

    public Location getLocationNonAbo(String codeSecret) {
        return locationRepository.getLocationNonAboByCodeSecret(codeSecret);
    }

    public List<Location> getLocationAbo(String codeSecret,String cb) {
        return locationRepository.getLocationAbo(codeSecret,cb);
    }


    /**
     * Transforme un json contenant les information d'une location afin de pouvoir effectuer le retour d'une location
     * update des bornettes avec leur nouveau velo
     * set de la date de fin
     * update de l'etat des velo
     * @param json le json recuperer par la requete
     * @return true
     */
    public boolean retourLocation(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray velosHS = null;
        JSONArray bornettesJson = null;
        Location location = null;
        Long idLoc = null;
        List<Velo> velos = new ArrayList<>();
        List<Bornette> bornettes = new ArrayList<>();
        if(jsonObject.has("idlocation")){
            idLoc = jsonObject.getLong("idlocation");
            location = locationRepository.getById(idLoc);
            velos = location.getVelos();
        }
        if(jsonObject.has("listeveloHS")){
            velosHS = jsonObject.getJSONArray("listeveloHS");
        }
        if(jsonObject.has("bornettes")){
            bornettesJson = jsonObject.getJSONArray("bornettes");
        }
        for (int i = 0; i < bornettesJson.length(); i++) {
            bornettes.add(bornetteRepository.findBornetteById(bornettesJson.getLong(i)));
        }
        int i =0;
        for (Velo v: velos) {
            bornettes.get(i).setVelo(v);
            i++;
        }
        for (int j = 0; j < velosHS.length(); j++) {
            Velo v = veloRepository.getVeloByBornetteId(bornettesJson.getLong(j));
            v.setEtat(Etat.HS);
            veloRepository.save(v);
        }
        location.setDateFin(new GregorianCalendar().getTime());
        locationRepository.save(location);
        bornetteRepository.saveAll(bornettes);
        return true;
    }
}

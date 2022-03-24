package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.enums.Sexe;
import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.services.ClientAboService;
import com.cfmgg.vpick.models.ClientAbonne;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public ClientAbonne isSubscriber(@PathVariable("codeSecret") String codeSecret, @PathVariable("carteBancaire") String carteBancaire){
        ClientAbonne client =  clientAboService.isSubscriber(codeSecret,carteBancaire);
        System.out.println(client);
        return client;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public void updateCreditTemps(@RequestBody String client){
        clientAboService.updateCreditTemps(client);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public @ResponseBody Boolean newSubscriber(@RequestBody String client) throws ParseException {
        boolean retour = false;
        System.out.println(client);
        JSONObject json = new JSONObject(client);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if(json.has("nom")&&json.has("prenom")&&json.has("dateNaissance")&&json.has("adresse")&&json.has("sexe")&&json.has("codeSecret")&&json.has("carteBancaire")&&json.has("dateDebut")&&json.has("dateFin")&&json.has("creditTemps")){
            String nom = json.getString("nom");
            String prenom = json.getString("prenom");
            String dateNaissance = json.getString("dateNaissance");
            String adresse = json.getString("adresse");
            String sexeString = json.getString("sexe");
            String codeSecret = json.getString("codeSecret");
            String carteBancaire = json.getString("carteBancaire");
            String dateDebut = json.getString("dateDebut");
            String dateFin = json.getString("dateFin");
            int creditTemps = Integer.parseInt(json.getString("creditTemps"));
            Sexe sexe;
            if(sexeString.equals("HOMME")){
                sexe=Sexe.HOMME;
            }else{
                sexe=Sexe.FEMME;
            }
            Date naissance = fmt.parse(dateNaissance);
            Date debutAbo = fmt.parse(dateDebut);
            Date finAbo = fmt.parse(dateFin);
            ClientAbonne clientAbo = null;
            if(clientAboService.notSubscribe(codeSecret,carteBancaire)){
                clientAbo= new ClientAbonne(
                        carteBancaire,
                        nom,
                        prenom,
                        naissance,
                        adresse,
                        sexe,
                        codeSecret,
                        creditTemps,
                        debutAbo,
                        finAbo
                );
                clientAboService.newSubscriber(clientAbo);
            }else{
                clientAbo = clientAboService.isSubscriber(codeSecret,carteBancaire);
                Calendar c = Calendar.getInstance();
                c.setTime(clientAbo.getDateFinAbonnement());
                c.add(Calendar.YEAR,1);
                Date dateFinAbo = c.getTime();
                clientAbo.setDateFinAbonnement(dateFinAbo);
                clientAboService.updateClient(clientAbo);
            }
            retour = true;
        }
        return retour;
    }
}

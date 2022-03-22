package com.cfmgg.vpick.Controllers;

import com.cfmgg.vpick.enums.Sexe;
import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.services.ClientAboService;
import com.cfmgg.vpick.models.ClientAbonne;
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
    @RequestMapping(value = "/cb/{carteBancaire}/code/{codeSecret}", method = RequestMethod.GET)
    public ClientAbonne isSubscriber(@PathVariable("codeSecret") String codeSecret, @PathVariable("carteBancaire") String carteBancaire){
        return clientAboService.isSubscriber(codeSecret,carteBancaire);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public @ResponseBody Boolean newSubscriber(@RequestBody String client) throws ParseException {
        ClientAbonne clientAbo = null;
        System.out.println(client);
        client = client.substring(1,client.length()-1);
        boolean isInString = false;
        for(int i = 0 ; i < client.length();i++){
            if(client.charAt(i)=='"'){
                isInString = !isInString;
            }else{
                if(client.charAt(i)==':' && !isInString){
                    client = client.substring(0,i)+','+client.substring(i+1);
                }
            }
        }
        ArrayList<String> info = new ArrayList<>(Arrays.asList(client.split(",")));
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String cb =  info.get(13).substring(1,info.get(13).length()-1);
        String nom = info.get(1).substring(1,info.get(1).length()-1);
        String prenom =info.get(3).substring(1,info.get(3).length()-1);
        String adresse = info.get(7).substring(1,info.get(7).length()-1);
        Sexe sexe;
        System.out.println(info.get(9));
        if(info.get(9).substring(1,info.get(9).length()-1).equals("HOMME")){
            sexe=Sexe.HOMME;
        }else{
            sexe=Sexe.FEMME;
        }
        String codeSecret = info.get(11).substring(1,info.get(11).length()-1);
        int creditTemps = 0;
        Date naissance = fmt.parse(info.get(5).substring(1,info.get(5).length()-1));
        Date debutAbo = fmt.parse(info.get(15).substring(1,info.get(15).length()-1));
        Date finAbo = fmt.parse(info.get(17).substring(1,info.get(17).length()-1));
        if(info.size()==20){
            clientAbo= new ClientAbonne(
                    cb,
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
        }
        clientAboService.newSubscriber(clientAbo);
        return true;
    }
}

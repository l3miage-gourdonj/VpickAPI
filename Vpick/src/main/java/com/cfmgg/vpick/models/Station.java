package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "station")
/**
 * une station possede
 * une adresse pour pouvoir la localiser
 * une liste de bornette(tout celle lier a ce parc)
 * une liste de plage horaire definissant les variations de status
 * de la station au court de la journée
 */
public class Station {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "adresse", nullable = false, length = 30, unique = true)
    private String adresse;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bornette> bornettes;

    @OneToMany
    private List<PlageHoraire> plagesHoraires;

    public Station(String adresse){
        this.adresse = adresse;
    }

    public Station(String adresse, List<Bornette> bornettes){
        this.adresse = adresse;
        this.bornettes = bornettes;
    }

}


package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
/**
 * Une location possede
 * une liste de velo (tout ceux emprumpter au moment de la location)
 * Un client s'il est abonné afin de lier la location sinon null
 * une date de debut et de fin
 * un code secret aleatoire si non abonne sinon celui du client
 * un prix mais on ne le stock pas on le calcul juste
 */
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Velo> velos;

    @ManyToOne
    private Client client;

    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;
    @Column(name = "code_secret", updatable = false)
    private String codeSecret;
    @Transient
    private Double prix;

    public Location(List<Velo> velos, Client client, Date dateDebut, Date dateFin, String codeSecret) {
        this.velos = velos;
        this.client = client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.codeSecret = codeSecret;
    }

    /**
     * Calcul du prix
     * @return prix le montant de la location
     */

    public Double getPrix(){
        double prix=0.00;
        if(dateFin!=null){
            for(Velo v : velos){
                prix+= v.getModele().getCoutHoraire();
            }
            prix *= Math.round((double)(dateFin.getTime()-dateDebut.getTime())/3600000);
        }
        System.out.println(prix);
        return prix;
    }
}

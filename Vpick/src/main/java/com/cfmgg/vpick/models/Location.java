package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
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

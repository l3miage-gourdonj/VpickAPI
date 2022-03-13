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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Velo> velos;

    @OneToOne
    private Client client;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;
    @Column(name = "code_secret", updatable = false)
    private String codeSecret;
    @Transient
    private Float prix;

    public Location(List<Velo> velos, Client client, Date dateDebut, Date dateFin, String codeSecret) {
        this.velos = velos;
        this.client = client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.codeSecret = codeSecret;
    }

    public Float getPrix(){
        float prix=0.00F;
        if(dateFin!=null){
            for(Velo v : velos){
                prix+= v.getModele().getCoutHoraire();
            }
            prix *= Math.round((float)(dateFin.getTime()-dateDebut.getTime())/3600000);
        }
        return prix;
    }
}

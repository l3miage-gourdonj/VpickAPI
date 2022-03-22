package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "velo")
public class Velo {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="date_mise_en_service")
    private Date dateMiseEnService;
    private Etat etat;
    private StatusVelo status;

    @ManyToOne
    private Modele modele;

    public Velo(Date dateMiseEnService, Etat etat, StatusVelo status, Modele modele){
        this.dateMiseEnService = dateMiseEnService;
        this.etat = etat;
        this.status = status;
        this.modele = modele;
    }
}

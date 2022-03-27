package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "velo")
/**
 * Un velo possede une date de mise en service afin d'avoir une tracabilité des velos
 * un etat pour dire s'il est utilisable ou s'il est casser et doit etre réparer
 * un status permettant de savoir ce que fait le velo a nimporte quel moment(louee,libre ou en maintenance)
 * un modele
 */
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

package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.StatusStation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "plage_horaire")

/**
 * Une plage horaire possede
 * une heure de debut et de fin
 * un status de station permettant de savoir si l'utilisateur gagnera des credit temps
 */
public class PlageHoraire {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "status_courant")
    private StatusStation statusCourant;

    @Column(name = "heure_debut")
    private Date heureDebut;

    @Column(name = "heure_fin")
    private Date heureFin;


    public PlageHoraire(StatusStation statusCourant, Date heureDebut, Date heureFin) {
        this.statusCourant = statusCourant;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }
}

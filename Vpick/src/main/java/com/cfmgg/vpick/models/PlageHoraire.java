package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.StatusStation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "plage_horaire")
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


}
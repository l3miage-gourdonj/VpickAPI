package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import com.cfmgg.vpick.enums.StatusVelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "velo")
public class Velo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date_mise_en_service")
    private Date dateMiseEnService;
    private Etat etat;
    private StatusVelo status;

    @OneToOne
    private Location location;
    @OneToOne
    private Modele modele;
    @OneToOne
    private Bornette bornette;

    public Velo(Date dateMiseEnService, Etat etat, StatusVelo status, Modele modele, Bornette bornette){
        this.dateMiseEnService = dateMiseEnService;
        this.etat = etat;
        this.status = status;
        this.modele = modele;
        this.bornette = bornette;
    }
}

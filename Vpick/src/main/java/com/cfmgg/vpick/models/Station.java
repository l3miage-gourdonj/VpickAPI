package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.StatusStation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "adresse", nullable = false, length = 30, unique = true)
    private String adresse;

    private StatusStation status;

    @OneToMany
    private List<Bornette> bornettes;

    @OneToMany
    private List<PlageHoraire> plagesHoraires;

    public Station(String adresse, StatusStation status){
        this.adresse = adresse;
        this.status = status;
    }

}


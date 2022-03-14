package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.StatusStation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "station", uniqueConstraints = {
        @UniqueConstraint(name = "station_adresse_unique", columnNames = {"adresse"})
})
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adresse",  nullable = false,length = 30)
    private String adresse;

    public Station(String adresse){
        this.adresse = adresse;
    }

}


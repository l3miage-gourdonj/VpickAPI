package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bornette")
public class Bornette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Etat etat;

    @OneToOne
    private Station station;

    public Bornette(Etat etat, Station station){
        this.etat = etat;
        this.station = station;
    }

}

package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bornette")
public class Bornette {

    @Id
    @GeneratedValue
    private Long id;

    private Etat etat;

    @OneToOne
    private Velo velo;

    @ManyToOne
    private Station station;

    public Bornette(Etat etat, Velo velo){
        this.etat = etat;
        this.velo = velo;
    }

}

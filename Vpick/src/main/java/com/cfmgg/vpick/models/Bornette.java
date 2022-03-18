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
    private int numero;
    private Etat etat;

    @OneToOne
    private Velo velo;

    @ManyToOne
    private Station station;

    public Bornette(int numero,Etat etat, Velo velo){
        this.numero = numero;
        this.etat = etat;
        this.velo = velo;
    }

}

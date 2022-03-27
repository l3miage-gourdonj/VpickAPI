package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Etat;
import lombok.*;

import javax.persistence.*;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bornette")
/*
 * Une bornette pourra acceuillir un velo
 * un numero pour la differencier des autre bornette d'une meme station
 * un etat car la bornette peut etre casser la rendant inutilisable
 */
public class Bornette {

    @Id
    @GeneratedValue
    private Long id;
    private int numero;
    private Etat etat;

    @OneToOne
    private Velo velo;


    public Bornette(int numero,Etat etat, Velo velo){
        this.numero = numero;
        this.etat = etat;
        this.velo = velo;
    }

}

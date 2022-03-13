package com.cfmgg.vpick.models;

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
@Table(name = "modele")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String modele;

    @Column(name = "cout_horaire", nullable = false)
    private float coutHoraire;

    public Modele(String modele, Float coutHoraire){
        this.modele = modele;
        this.coutHoraire = coutHoraire;
    }
}

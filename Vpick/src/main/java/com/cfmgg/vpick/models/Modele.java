package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.*;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "modele")
/**
 * Un modele possede
 * un nom
 * un cout horaire
 */
public class Modele {

    @Id
    @GeneratedValue
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

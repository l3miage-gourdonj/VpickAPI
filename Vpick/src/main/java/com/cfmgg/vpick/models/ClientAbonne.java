package com.cfmgg.vpick.models;

import com.cfmgg.vpick.enums.Sexe;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("yes")
/**
 * Un client abonné renseignera
 * son nom
 * son prenom
 * une date de naissance
 * une adresse
 * son sexe
 * un code secret utiliser pour se connecter
 * les dates d'abonnement sont automatiques
 */
public class ClientAbonne extends Client{

    private String nom;

    private String prenom;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    private String adresse;

    private Sexe sexe;

    @Column(name = "code_secret")
    private String codeSecret;

    @Column(name = "credit_temps")
    private int creditTemps;

    @Column(name = "date_debut_abonnement")
    private Date dateDebutAbonnement;

    @Column(name = "date_fin_abonnement")
    private Date dateFinAbonnement;

    public ClientAbonne(String carteBancaire, String nom, String prenom, Date dateNaissance, String adresse, Sexe sexe, String codeSecret, int creditTemps, Date dateDebutAbonnement, Date dateFinAbonnement) {
        super(carteBancaire);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.sexe = sexe;
        this.codeSecret = codeSecret;
        this.creditTemps = creditTemps;
        this.dateDebutAbonnement = dateDebutAbonnement;
        this.dateFinAbonnement = dateFinAbonnement;
    }
}

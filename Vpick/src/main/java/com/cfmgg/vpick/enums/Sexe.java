package com.cfmgg.vpick.enums;

/**
 * Sexe d'une personne
 * homme
 * femme
 * possibilité d'en rajouter pour plaire a tout le monde si besoin
 * (necessiterai quelque ajustement)
 */
public enum Sexe {
    FEMME("femme"),
    HOMME("homme");

    private String nom;

    Sexe(String nom) {
        this.nom = nom;
    }
}

package com.cfmgg.vpick.enums;

/**
 * Cette enumeration liste les deux etat dans lesquels peuvent se trouver un velo ou une bornette
 * ok -> tout va bien
 * hs -> cest en panne
 */

public enum Etat {
    OK("ok"),
    HS("hs");

    private String nom;

    Etat(String nom) {
        this.nom = nom;
    }
}

package com.cfmgg.vpick.enums;

/**
 * Permet de definir dans une plage horaire si une station est
 * vplus
 * vmoin
 * vnul
 * Cela permet de gerer l'attribution ou non de credit lors du retour de la location
 */

public enum StatusStation {
    VPLUS("Vplus"),
    VMOINS("Vmoins"),
    VNUL("Vnul");

    private String nom;

    StatusStation(String nom) {
        this.nom = nom;
    }
}

package com.cfmgg.vpick.enums;

public enum StatusStation {
    VPLUS("Vplus"),
    VMOINS("Vmoins"),
    VNUL("Vnul");

    private String nom;

    StatusStation(String nom) {
        this.nom = nom;
    }
}

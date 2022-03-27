package com.cfmgg.vpick.enums;

/**
 * Permet de savoir ou ce trouve un velo a n'importe quel moment
 * soit en cours de location
 * soit a une bornette en attente d'une location
 * soit en maintenance car casser
 */
public enum StatusVelo {
    LIBRE("libre"),
    LOUE("loué"),
    MAINTENANCE("maintenance");
    
    private String nom;
    
    StatusVelo(String nom){
        this.nom = nom;
    }
}

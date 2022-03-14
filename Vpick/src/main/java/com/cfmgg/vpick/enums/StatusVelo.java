package com.cfmgg.vpick.enums;

public enum StatusVelo {
    LIBRE("libre"),
    LOUE("loué"),
    MAINTENANCE("maintenance");
    
    private String nom;
    
    StatusVelo(String nom){
        this.nom = nom;
    }
}

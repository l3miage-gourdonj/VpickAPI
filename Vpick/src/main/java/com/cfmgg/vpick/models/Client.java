package com.cfmgg.vpick.models;

import lombok.*;
import java.util.List;

import javax.persistence.*;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Inheritance( strategy = InheritanceType.JOINED )
@Entity
@DiscriminatorColumn(name = "abonne")
/*
 * un client abonne ou non aura au moin un cb attribuer
 */
public abstract class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "carte_bancaire", nullable = false)
    private String carteBancaire;

    public Client(String carteBancaire) {
        this.carteBancaire = carteBancaire;
    }
}

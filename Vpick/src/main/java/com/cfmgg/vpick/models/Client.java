package com.cfmgg.vpick.models;

import lombok.*;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@Inheritance( strategy = InheritanceType.JOINED )
@Entity
@DiscriminatorColumn(name = "abonne")
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

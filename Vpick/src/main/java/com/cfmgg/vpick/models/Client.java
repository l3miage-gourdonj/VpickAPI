package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "carte_bancaire",
    nullable = false)
    private String carteBancaire;

    public Client( String carteBancaire) {
        this.carteBancaire = carteBancaire;
    }
}

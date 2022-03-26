package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * annotation de lombok reduit le code inutile
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("no")
/**
 * un client non abonné n'a besoin d'aucune information supplémentaire seul ca carte bancaire est necessaire afin de payer
 */
public class ClientNonAbonne extends Client {

    public ClientNonAbonne(String carteBancaire){
        super(carteBancaire);
    }
}

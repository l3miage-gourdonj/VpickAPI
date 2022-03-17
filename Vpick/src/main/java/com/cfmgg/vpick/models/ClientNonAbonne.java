package com.cfmgg.vpick.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("no")
public class ClientNonAbonne extends Client {

    public ClientNonAbonne(String carteBancaire){
        super(carteBancaire);
    }
}

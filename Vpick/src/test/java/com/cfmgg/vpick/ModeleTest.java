package com.cfmgg.vpick;

import com.cfmgg.vpick.models.Modele;
import com.cfmgg.vpick.repositories.ModeleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ModeleTest {
    @Autowired
    ModeleRepository modeleRepository;


    @Test
    void shouldSaveNewModele(){
        Modele hero = new Modele("HERO",99.99F);
        modeleRepository.save(hero);
        Modele modeleFound = modeleRepository.findModeleByModele("HERO");
        assertThat(modeleFound.getId()).isEqualTo(hero.getId());
    }



}

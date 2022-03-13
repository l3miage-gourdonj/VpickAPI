package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Modele;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureMockMvc
public class ModeleTest {

    @Autowired
    private ModeleRepository modeleRepository;

    @Test
    public void shouldSaveModele(){
        Modele modele = new Modele("Nike", 12.99F);
        modeleRepository.save(modele);
        Modele modeleFound = modeleRepository.findModeleByModele("Nike");
        assertThat(modeleFound.getId()).isEqualTo(modeleFound.getId());

    }

    @Test
    public void shouldFindModeleByCoutHoraire(){
        float coutH = 9.99F;
        List<Modele> modeles = modeleRepository.findModeleByCoutHoraire(coutH);
        assertThat(modeles.size()).isEqualTo(2);
    }

    @Test
    public void shouldFindModeleByModele(){
        Modele modele = modeleRepository.findModeleByModele("Nike");
        assertThat(modele.getModele()).isEqualTo("Nike");
    }
}

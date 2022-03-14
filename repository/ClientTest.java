package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Client;
import com.cfmgg.vpick.models.ClientAbonne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ClientTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void shouldSaveClient() {
        Client client = new Client("1234 1345 1243 3456");
        clientRepository.save(client);

        Client clientFound = clientRepository.findClientByCB(client.getCarteBancaire());

        assertThat(clientFound.getId()).isEqualTo(client.getId());
    }

    @Test
    public void shouldRetrieveClientAbonne(){
        ClientAbonne client = clientRepository.findClientByCodeSecret("12345");
        assertThat(client.getPrenom()).isEqualTo("Georges");
    }


}
package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Client;

import static org.junit.jupiter.api.Assertions.*;

class IClientTest {
    private static IClient iClient;

    @BeforeAll
    public static void init() {
        iClient = new ClientImpl();
    }

    @Test
    void getAllClients() {
    }

    @Test
    void getClientById() {
        Assertions.assertNotNull(iClient.getClientById(1), "LE Test getClientById a echoué");
    }

    @Test
    void getClientByEmail() {
        Assertions.assertNotNull(iClient.getClientByEmail("blackbeard@email.op"), "LE Test getClientByEmail a echoué");
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Diallo");
        client.setPrenom("saliou");
        Assertions.assertEquals(8, iClient.addClient(client).getId(), "La methode addClient a echoué");
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void getAllCommandesOfClientId() {
        Assertions.assertNotNull( iClient.getAllCommandesOfClientId(1), "La methode getAllCommandesOfClientId a echoué");
    }
}
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
        Assertions.assertNotNull( iClient.getAllClients(), "La methode getAllClient à echoué");
    }

    @Test
    void getClientById() {
        Assertions.assertNotNull(iClient.getClientById(1), "LE Test getClientById à echoué");
    }

    @Test
    void getClientByEmail() {
        Assertions.assertNotNull(iClient.getClientByEmail("blackbeard@email.op"), "LE Test getClientByEmail a echoué");
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Eren");
        client.setPrenom("yegger");
        Assertions.assertEquals(9, iClient.addClient(client).getId(), "La methode addClient a echoué");
    }

    @Test
    void updateClient() {

        Client client = new Client();
        client.setId(9);
        client.setNom("Moustapha");
        client.setPrenom("Diallo");
        Assertions.assertNotNull( iClient.updateClient(9, client), "La methode updateClient a echoué");
    }

    @Test
    void deleteClient() {
        Assertions.assertEquals( true, iClient.deleteClient(9), "La methode deleteClient a echoué");
    }

    @Test
    void getAllCommandesOfClientId() {
        Assertions.assertNotNull( iClient.getAllCommandesOfClientId(1), "La methode getAllCommandesOfClientId a echoué");
    }
}

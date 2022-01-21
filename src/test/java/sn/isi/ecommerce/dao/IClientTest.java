package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.*;
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
        Assertions.assertNotNull( iClient.getAllClients(), "La methode getAllClients a echoué");
    }

    @Test
    void getClientById() {
        Assertions.assertNotNull(iClient.getClientById(1), "LE Test getClientById a echoué");
    }

    @Test
    void getClientByEmail() {
        Assertions.assertNotNull(iClient.getClientByEmail("issasow@gmail.com"), "LE Test getClientByEmail a echoué");
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Diallo");
        client.setPrenom("saliou");
        int id = iClient.util() + 1;
        Assertions.assertEquals(49, iClient.addClient(client).getId(), "La methode addClient a echoué");
    }

    @Test
    void updateClient() {

        Client client = new Client();
        client.setId(1);
        client.setNom("Issa");
        client.setPrenom("Sow");
        client.setEmail("issasow@gmail.com");
        Assertions.assertNotNull( iClient.updateClient(1, client), "La methode updateClient a echoué");
    }

    @Test
    void deleteClient() {
        int id = iClient.util();
        Assertions.assertEquals( true, iClient.deleteClient(id), "La methode deleteClient a echoué");
    }

    /*@Test
    void getAllCommandesOfClientId() {
        Assertions.assertNotNull( iClient.getAllCommandesOfClientId(1), "La methode getAllCommandesOfClientId a echoué");
    }*/
}
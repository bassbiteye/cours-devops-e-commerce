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
        assertNotNull( iClient.getAllClients(), "La methode getAllClients a echoué");
    }

    @Test
    void getClientById() {
        assertNotNull(iClient.getClientById(8), "LE Test getClientById a echoué");
    }

    @Test
    void getClientByEmail() {
        assertNull ( iClient.getClientByEmail("penda@gmail.com"),"LE Test getClientByEmail a echoué");
    }

   /* @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Diop");
        client.setPrenom("Ayleun");
        int id = iClient.util() + 1;
        assertEquals(41, iClient.addClient(client).getId(), "La methode addClient a echoué");
    }    */

    @Test
    void updateClient() {

        Client client = new Client();
        client.setId(8);
        client.setNom("Ndiaye");
        client.setPrenom("Penda");
        client.setEmail("penda@gmail.com");
        assertNotNull( iClient.updateClient(8, client), "La methode updateClient a echoué");
    }

    @Test
    void deleteClient() {
        int id = iClient.util();
        assertEquals( true, iClient.deleteClient(id), "La methode deleteClient a echoué");
    }

    /*@Test
    void getAllCommandesOfClientId() {
        Assertions.assertNotNull( iClient.getAllCommandesOfClientId(1), "La methode getAllCommandesOfClientId a echoué");
    }*/
}
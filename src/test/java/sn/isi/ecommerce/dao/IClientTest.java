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
        assertNotNull(iClient.getClientById(2), "LE Test getClientById a echoué");
    }

    @Test
    void getClientByEmail() {
        assertNull ( iClient.getClientByEmail("penda@gmail.com"),"LE Test getClientByEmail a echoué");
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Diallo");
        client.setPrenom("Moustapha");
        int id = iClient.util() + 1;
        //assertEquals(41, iClient.addClient(client).getId(), "La methode addClient a echoué");
        Assertions.assertEquals(client.getNom(), iClient.addClient(client).getNom(), "La methode addClient a echouÃ©");
    }

    @Test
    void updateClient() {

        Client client = new Client();
        client.setId(8);
        client.setNom("Diallo");
        client.setPrenom("Moustapha");
        client.setEmail("diallo@gmail.com");
        Assertions.assertNotNull( iClient.updateClient(2, client), "La methode updateClient a echouÃ©");
    }

    @Test
    void deleteClient() {
        int id = iClient.util();
        Assertions.assertEquals( true, iClient.deleteClient(id), "La methode deleteClient a echouÃ©");
    }

    /*@Test
    void getAllCommandesOfClientId() {
        Assertions.assertNotNull( iClient.getAllCommandesOfClientId(1), "La methode getAllCommandesOfClientId a echoué");
    }*/
}
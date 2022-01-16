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
        Assertions.assertNotNull(iClient.getAllClients(), "Test getAllClient a echoué");
    }

    @Test
    void getClientById() {
    }

    @Test
    void getClientByEmail() {
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setNom("Daru");
        client.setPrenom("Bakala");
        Assertions.assertEquals(5, iClient.addClient(client).getId(), "La methode addClient a echoué");
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void checkIfClientIdExists() {
    }

    @Test
    void getAllCommandesOfClientId() {
    }
}
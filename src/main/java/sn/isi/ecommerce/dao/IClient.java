package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;

import java.util.List;

public interface IClient {
    List<Client> getAllClient();
    Client getClientById(int id);
    Client getClientByEmails(String email);
    Client addClients(Client client);
    Client updateClients(int id, Client client);
    boolean deleteClients(int id);
    List<Commande> getAllCommandesOfClientId(int id);
    int util();
}

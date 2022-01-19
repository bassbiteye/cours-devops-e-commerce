package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;

import java.util.List;

public interface IClient {
    List<Client> getAllClients();
    Client getClientById(int id);
    Client getClientByEmail(String email);
    Client addClient(Client client);
    Client updateClient(int id, Client client);
    boolean deleteClient(int id);
    List<Commande> getAllCommandesOfClientId(int id);
}

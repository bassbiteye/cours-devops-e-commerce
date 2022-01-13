package sn.isi.ecommerce.services;

import sn.isi.ecommerce.entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(int id);
    Client getClientByEmail(String email);
    Client createClient(Client client);
    Client updateClient(int id, Client client);
    boolean deleteClient(int id);
}

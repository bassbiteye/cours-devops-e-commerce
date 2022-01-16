package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;

import java.util.List;

public class ClientImpl implements IClient {

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public Client getClientByEmail(String email) {
        return null;
    }

    @Override
    public Client addClient(Client client) {
        return null;
    }

    @Override
    public Client updateClient(int id, Client client) {
        return null;
    }

    @Override
    public boolean deleteClient(int id) {
        return false;
    }

    @Override
    public boolean checkIfClientIdExists(int id) {
        return false;
    }

    @Override
    public List<Commande> getAllCommandesOfClientId(int id) {
        return null;
    }
}

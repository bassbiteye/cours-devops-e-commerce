package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements IClient {
    private EntityManager entityManager;

    public  ClientImpl() {
        entityManager = Persistence.createEntityManagerFactory("ecommercePU")
                .createEntityManager();
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    public Client getClientById(int id) {
        try{
            return entityManager.find(Client.class, id);
        }catch (Exception exencep){
            exencep.printStackTrace();
            return null;
        }
    }

    @Override
    public Client getClientByEmail(String email) {
        try{
            Client client = (Client) entityManager.createQuery("SELECT c FROM Client c WHERE c.email = :email")
                    .setParameter("email", email).getSingleResult();
            return client;
        }catch (Exception exencep){
            exencep.printStackTrace();
            return null;
        }
    }

    @Override
    public Client addClient(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            return client;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
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
    public List<Commande> getAllCommandesOfClientId(int id) {

        try {
            List<Commande> commandes = entityManager.createQuery("SELECT c FROM Commande c WHERE c.client = :id")
                    .setParameter("id", id).getResultList();
            return commandes ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

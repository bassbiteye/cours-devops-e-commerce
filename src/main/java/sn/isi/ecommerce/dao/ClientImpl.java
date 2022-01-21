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

    public EntityManager getEntityManager() {
        return  this.entityManager;
    }

    @Override
    public List<Client> getAllClients() {
        try {
            return entityManager.createQuery("SELECT c FROM Client c").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
        try {
            if (this.getClientById(id) == null){
                return null;
            }

            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
            return client;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteClient(int id) {
        try {
            Client client = entityManager.find(Client.class, id);
            if (this.getClientById(id) == null){
                return false;
            }

            entityManager.getTransaction().begin();
            entityManager.remove(client);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
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

    @Override
    public int util() {
       int id = (int) entityManager.createNativeQuery("SELECT id FROM client ORDER BY id DESC LIMIT 0,1")
               .getSingleResult();
       return id;
    }
}

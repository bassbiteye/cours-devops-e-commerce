package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Facturation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class FactureImpl implements IFacturation {
    private EntityManager em;
    private Facturation facture;
    public FactureImpl() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }

    @Override
    public List<Facturation> getAllFacture() {
        return null;
    }

    @Override
    public Facturation saveFacture(Client client, Commande commande) {
        List<Client> clients = new ArrayList<Client>();
//        List<Commande> commandes = new ArrayList<Commande>();
//        commandes.add(commande);
        clients.add(client);
//        facture.setClient(clients);
        facture.setCommande(commande);
        try {
            em.getTransaction().begin();
            em.persist(facture);
            em.getTransaction().commit();
            return facture;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

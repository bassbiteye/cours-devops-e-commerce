package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Commande;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CommandeImpl implements  ICommande{

    private EntityManager em;

    public CommandeImpl(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }
    @Override
    public Commande addCommande(Commande commande) {
        try{
            em.persist(commande);
            return commande;
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public Commande getCommande(int idCommande) {
        try{
        Commande commande = em.find(Commande.class,idCommande);
        return commande;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void deleteCommande(int idCommande) {
        try{
            em.remove(em.find(Commande.class,idCommande));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Commande> getAllCommande() {
        List<Commande> listCommande;
        listCommande=em.createQuery("SELECT c FROM Commande c").getResultList();
        return listCommande ;
    }

    @Override
    public List<Commande> getCommandeByClient(int idClient) {
        try{
            List<Commande> listCommandeClient;
            listCommandeClient =  em.createQuery("SELECT c FROM Commande c where c.client.id=:x")
                    .setParameter("x",idClient).getResultList();

            return listCommandeClient;

        }catch (Exception e){
           e.printStackTrace();
           return  null;
        }
    }

    @Override
    public void updateCommande(Commande commande) {
        try {
          em.merge(commande);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

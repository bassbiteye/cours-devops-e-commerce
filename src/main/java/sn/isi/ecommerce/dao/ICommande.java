package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Commande;

import java.util.List;

public interface ICommande {

    public Commande addCommande(Commande commande);
    public  Commande getCommande(int idCommande);
    public void deleteCommande(int idCommande);
    public List<Commande> getAllCommande();
    public List<Commande> getCommandeByClient(int idClient);
    public void updateCommande(Commande commande);

}

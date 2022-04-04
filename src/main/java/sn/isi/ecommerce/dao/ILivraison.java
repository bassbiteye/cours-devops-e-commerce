package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Livraison;

import java.util.List;


/**

 *
 */
public interface ILivraison {
    List<Livraison> getAllLivraison();
    Livraison saveLivraison(Commande commande);
    public Livraison get(String livraison);
}
/**
 * 
 */
package sn.isi.ecommerce.dao;

import java.util.List;

import sn.isi.ecommerce.entities.*;


/**
 * @author hp
 *
 */
public interface ILivraison {
	 List<Livraison> getAllLivraison();
	 Livraison saveLivraison(Commande commande);
	 public Livraison get(String livraison);
}

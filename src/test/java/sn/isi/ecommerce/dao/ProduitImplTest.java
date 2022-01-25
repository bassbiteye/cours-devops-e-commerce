package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.dao.IProduit;
import sn.isi.ecommerce.dao.ProduitImpl;
import sn.isi.ecommerce.entities.Produit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProduitImplTest {

    @Test
    void add() {
        IProduit produitDao = new ProduitImpl();
        ICategorie categorieDao = new CategorieImpl();
        Produit produit = new Produit();
        produit.setLibelle("HP5");
        produit.setDescription("Ordinateur HP5");
        produit.setCategorie(categorieDao.get(1));
        produit.setQuantite(100);
        produit.setDateDePeremption(null);
        int result = produitDao.add(produit);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");

    }

    @Test
    void update() {
        IProduit produitDao = new ProduitImpl();
        ICategorie categorieDao = new CategorieImpl();
        Produit produit =produitDao.get(1);

        produit.setLibelle("HP5modifier");
        produit.setDescription("Ordinateur HP5modifier");
        produit.setCategorie(categorieDao.get(1));
        produit.setQuantite(100);
        produit.setDateDePeremption(null);
        int result = produitDao.update(produit);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");

    }

    @Test
    void delete() {
        IProduit produitdao = new ProduitImpl();
        int result = produitdao.delete(1);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
    }

    @Test
    void get() {
        IProduit produitdao = new ProduitImpl();
        Produit produit = produitdao.get(1);
        if(produit != null)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
    }

    @Test
    void getAll() {
        IProduit produitdao = new ProduitImpl();
        List<Produit> produits = produitdao.getAll();
        if(produits.size() > 0)
            System.out.println("List contains " + produits.size() + " produits");
        else
            System.out.println("List empty");
    }
}

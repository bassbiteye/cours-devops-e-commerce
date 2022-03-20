package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Detail;
import sn.isi.ecommerce.entities.Produit;

import static org.junit.jupiter.api.Assertions.*;

class DetailImplTest {

    private int ok = 0 ;
    private Detail detail ;
    private Produit produit ;
    private Commande commande ;
    private static IDetail detailDao ;
    @BeforeAll
    public static void init()
    {
        detailDao = new DetailImpl() ;
    }
    @Test
    void addDetail() {

        ok = detailDao.addDetail(detail) ;
        if(ok == 0)
        {
            System.out.println("Echec Ajout Detail commande");
        }
        else
        {
            System.out.println("Ajout reussie");
        }
    }

    @Test
    void deleteDetail() {
        Assertions.assertNotNull(detailDao.deleteDetail(1), "Echec Suppression d'un detail commande");

//        ok = detailDao.deleteDetail(1); ;
//        if(ok == 0)
//        {
//            System.out.println("Echec Suppression Detail commande");
//        }
//        else
//        {
//            System.out.println("Supression reussie");
//        }
    }

    @Test
    void getDetail() {
//        detail = detailDao.getDetail(1) ;
//        if(detail == null)
//        {
//            System.out.println("Deatil inexistante");
//        }
//        else
//        {
//            System.out.println("Get detail reussie");
//        }
//        Assertions.assertNotNull(detailDao.getDetail(1), "Echec recuperation d'un detail commande");
    }

    @Test
    void getAllDetail() {
        Assertions.assertNotNull( detailDao.getAllDetail(), "La methode getAllDetails a echoué") ;
    }
}
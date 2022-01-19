package sn.isi.ecommerce.dao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Fournisseur;
import sn.isi.ecommerce.entities.Users;

import java.util.ArrayList;
import java.util.List;


class FournisseurImplTest {
    private static IFournisseur iFournisseur;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addFournisseurWhenSuccess() {

        //initialisation
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("Nom");
        fournisseur.setPrenom("Prenom");
        fournisseur.setTelephone(778083808);
        fournisseur.setVille("Ville");
        fournisseur.setAdresse("Adresse");

        //save
        IFournisseur iFournisseur = new FournisseurImpl();
        int ok = iFournisseur.add(fournisseur);
        Assert.assertEquals(1,ok);

        return;
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        Assertions.assertEquals( true, iFournisseur.delete(9), "La methode delete a echoué");
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        IFournisseur iFournisseur = new FournisseurImpl();
        fournisseurs = iFournisseur.getAll();

        for (Fournisseur f: fournisseurs
        ) {
            System.out.println("Nom :"+f.getNom()+" Prenom : "+f.getPrenom());
        }
    }

    @Test
    void number() {
    }
}
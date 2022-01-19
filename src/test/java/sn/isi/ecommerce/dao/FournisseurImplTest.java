package sn.isi.ecommerce.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.entities.Fournisseur;
import sn.isi.ecommerce.entities.Users;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FournisseurImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
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
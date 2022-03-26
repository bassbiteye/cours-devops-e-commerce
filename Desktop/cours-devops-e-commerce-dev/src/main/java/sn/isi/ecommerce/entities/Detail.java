package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Commande commande = new Commande();
    @ManyToOne
    private Produit produit = new Produit();
}

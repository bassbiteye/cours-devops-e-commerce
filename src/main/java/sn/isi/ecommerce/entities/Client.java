package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60)
    private String prenom;
    @Column(length = 60)
    private String nom;
    @Column(length = 60)
    private String adresse;
    @Column(length = 60)
    private String ville;
    @Column(length = 20)
    private int telephone;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Commande> commandes = new ArrayList<Commande>();
}

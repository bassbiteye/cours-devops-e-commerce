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

    public Client() {
    }

    public Client(String prenom, String nom, String adresse, String ville, int telephone, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}

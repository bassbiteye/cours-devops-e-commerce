package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Fournisseur implements Serializable {

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

    public Fournisseur() {
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

    @Override
    public String toString() {
        return  prenom + " " + nom;
    }
}

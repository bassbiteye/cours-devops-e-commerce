package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60)
    private String prenom;
    @Column(length = 60)
    private String nom;
    @Column(length = 20)
    private String login;
    @Column(length = 20)
    private String password;

    public User(String prenom, String nom, String login, String password) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

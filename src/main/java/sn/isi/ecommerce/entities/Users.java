package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "user.all", query = "SELECT u FROM Users u"),
        @NamedQuery(name = "user.email", query = "SELECT u FROM Users u WHERE u.email =:em"),
        @NamedQuery(name = "user.logon", query = "SELECT u FROM Users u WHERE u.email LIKE :email AND u.password LIKE :password")
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 100)
    private String nom;
    @Column(length = 150)
    private String prenom;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(length = 4)
    private int etat;
    @ManyToMany
    private List<Roles> roles = new ArrayList<Roles>();

    public Users() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}

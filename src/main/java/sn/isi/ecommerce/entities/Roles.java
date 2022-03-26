package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "roles.all", query = "SELECT r FROM Roles r")
})
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, unique = true)
    private String nom;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users = new ArrayList<Users>();

    public Roles() {

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
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }
}

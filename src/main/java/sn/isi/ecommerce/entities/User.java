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
}

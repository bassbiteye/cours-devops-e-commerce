package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Facturation<client, commande> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private int numFact;
    @Column(length = 25)
    private Date dateFact;
//    @OneToOne(mappedBy = "facturation", fetch = FetchType.EAGER)
//    private Client client;
    @OneToOne(mappedBy = "facturation", fetch = FetchType.EAGER)
    private Commande commandes;



    public Facturation() {

    }
    public Facturation(int numFact, Date dateFact) {
        this.numFact = numFact;
        this.dateFact = dateFact;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumFact() {
        return numFact;
    }

    public int setNumFact(int numFact) {
        this.numFact = numFact;
        return numFact;
    }

    public Date getDateFact() {
        return dateFact;
    }

    public void setDateFact(Date dateFact) {
        this.dateFact = dateFact;
    }

    public Commande getCommandes() {
        return commandes;
    }

    public void setCommandes(Commande commandes) {
        this.commandes = commandes;
    }
}


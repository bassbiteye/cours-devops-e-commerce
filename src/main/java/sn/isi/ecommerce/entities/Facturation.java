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
    @OneToMany(mappedBy = "facturation", fetch = FetchType.EAGER)
    private ArrayList<client> client = new ArrayList<client>();
    @OneToMany(mappedBy = "facturation", fetch = FetchType.EAGER)
    private ArrayList<commande> commande = new ArrayList<commande>();



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

    public java.util.List<client> getClient() {
        return (java.util.List<client>) client;
    }

    public void setClient(List<client> client) {
        this.client = (ArrayList<client>) client;
    }

    public java.util.List<commande> getCommande() {
        return (java.util.List<commande>) commande;
    }

    public void setCommande(List<commande> commande) {
        this.commande = (ArrayList<commande>) commande;
    }



}


package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Client client = new Client();
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    private List<Detail> details = new ArrayList<Detail>();
    @OneToOne()
    private Facturation facturation;
    @OneToOne()
    private Livraison livraison;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Facturation getFacturation() {
        return facturation;
    }

    public void setFacturation(Facturation facturation) {
        this.facturation = facturation;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }
}

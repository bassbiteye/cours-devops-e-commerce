package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "stock.all", query = "SELECT s FROM stock s")
public class Stock  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qte;
    @ManyToOne
    private Produit produit = new Produit();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}

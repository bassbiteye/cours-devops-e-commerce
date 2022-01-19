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
}

package sn.isi.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Facturation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@OneToOne(optional=false, mappedBy="facturation")
    private Commande commande;

}

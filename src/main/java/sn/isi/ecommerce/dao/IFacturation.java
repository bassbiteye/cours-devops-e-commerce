package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Client;
import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Facturation;

import java.util.List;

public interface IFacturation {
    List<Facturation> getAllFacture();
    Facturation saveFacture(Client client, Commande commande);


}

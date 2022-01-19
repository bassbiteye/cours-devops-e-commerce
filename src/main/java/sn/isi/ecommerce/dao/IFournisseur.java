package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Fournisseur;

import java.util.List;


public interface IFournisseur {
	public int add(Fournisseur fournisseur);
	public int update(Fournisseur fournisseur);
	public int delete(int id);
	public Fournisseur get(int id);
	public List<Fournisseur> getAll();
	public int number(int id);
}

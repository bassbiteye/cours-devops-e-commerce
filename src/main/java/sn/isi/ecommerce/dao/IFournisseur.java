package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Fournisseur;

import java.util.List;


public interface IFournisseur {
	public int add(Fournisseur categorie);
	public int update(Fournisseur categorie);
	public int delete(int id);
	public Fournisseur get(int id);
	public List<Fournisseur> getAll();
}

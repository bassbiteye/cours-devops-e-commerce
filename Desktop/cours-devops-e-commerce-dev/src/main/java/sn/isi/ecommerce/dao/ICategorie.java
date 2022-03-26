package sn.isi.ecommerce.dao;

import java.util.List;

import sn.isi.ecommerce.entities.Categorie;


public interface ICategorie {
	public int add(Categorie categorie);
	public int update(Categorie categorie);
	public int delete(int id);
	public Categorie get(int id);
	public List<Categorie> getAll();
}

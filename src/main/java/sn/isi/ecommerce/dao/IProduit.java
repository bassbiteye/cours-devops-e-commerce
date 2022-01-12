package sn.isi.ecommerce.dao;

import java.util.List;

import sn.isi.ecommerce.entities.Produit;

public interface IProduit {
	public int add(Produit produit);
	public int update(Produit produit);
	public int delete(int id);
	public Produit get(int id);
	public List<Produit> getAll();
}

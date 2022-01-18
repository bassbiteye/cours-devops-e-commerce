package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Fournisseur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class FournisseurImpl implements IFournisseur {
	private EntityManager em;
	public FournisseurImpl()
	{
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ecommercePU");
		em = emf.createEntityManager();
	}


	@Override
	public int add(Fournisseur categorie) {
		return 0;
	}

	@Override
	public int update(Fournisseur categorie) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	public Fournisseur get(int id) {

		return em.find(Fournisseur.class, id);
	}

	public List<Fournisseur> getAll() {
		try {
			return em.createQuery("SELECT f FROM Fournisseur f").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

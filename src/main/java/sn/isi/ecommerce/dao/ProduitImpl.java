package sn.isi.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sn.isi.ecommerce.entities.Produit;

public class ProduitImpl implements IProduit {
	private EntityManager em;
	public ProduitImpl()
	{
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ecommercePU");
		em = emf.createEntityManager();
	}
	public int add(Produit produit) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(produit);
			em.getTransaction().commit();
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public int update(Produit produit) {
		try {
			em.getTransaction().begin();
			em.merge(produit);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Produit.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Produit get(int id) {

		return em.find(Produit.class, id);
	}

	public List<Produit> getAll() {
		try {
			return em.createQuery("SELECT p FROM Produit p").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

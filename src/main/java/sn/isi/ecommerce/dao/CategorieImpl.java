package sn.isi.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.ecommerce.entities.Categorie;


public class CategorieImpl implements ICategorie {
	private EntityManager em;
	public CategorieImpl()
	{
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ecommercePU");
		em = emf.createEntityManager();
	}
	public int add(Categorie categorie) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(categorie);
			em.getTransaction().commit();
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public int update(Categorie categorie) {
		try {
			em.getTransaction().begin();
			em.merge(categorie);
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
			em.remove(em.find(Categorie.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Categorie get(int id) {

		return em.find(Categorie.class, id);
	}

	public List<Categorie> getAll() {
		try {
			return em.createQuery("SELECT c FROM Categorie c").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

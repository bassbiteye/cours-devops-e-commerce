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
	public int add(Fournisseur fournisseur) {
		try {
			em.getTransaction().begin();
			em.persist(fournisseur);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	public int update(Fournisseur fournisseur) {
		try {
			em.getTransaction().begin();
			em.merge(fournisseur);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Fournisseur.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
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

	@Override
	public int number(int id) {
		try {
			List<Fournisseur> list = em.createQuery("SELECT f FROM Fournisseur f").getResultList();
			return list.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}

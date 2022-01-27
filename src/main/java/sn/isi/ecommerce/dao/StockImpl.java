package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Roles;
import sn.isi.ecommerce.entities.Stock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StockImpl implements IStock{
    private EntityManager em;
    public StockImpl() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }

    @Override
    public int add(Stock stock) {
        try {
            em.getTransaction().begin();
            em.persist(stock);
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Stock> getAll() {
        try {
            return em.createNamedQuery("stock.all").getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Detail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DetailImpl implements  IDetail {

    private EntityManager em;
    public DetailImpl(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }

    @Override
    public Detail addDetail(Detail detail) {
        em.persist(detail);
        return detail;
    }

    @Override
    public void deleteDetail(int idDetail) {
       em.remove(em.find(Detail.class,idDetail));
    }

    @Override
    public Detail getDetail(int idDetail) {
        return em.find(Detail.class,idDetail);
    }

    @Override
    public List<Detail> getAllDetail(){
        try{
            return em.createQuery("SELECT d FROM Detail d ").getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}

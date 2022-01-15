package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Roles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RolesImpl implements IRoles{
    private EntityManager em;
    public RolesImpl() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }

    @Override
    public int add(Roles role) {
        try {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Roles role) {
        try {
            em.getTransaction().begin();
            em.merge(role);
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Roles.class, id));
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Roles get(int id) {
        return em.find(Roles.class, id);
    }

    @Override
    public List<Roles> getAll() {
        try {
            return em.createNamedQuery("roles.all").getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

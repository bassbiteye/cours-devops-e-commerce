package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsersImpl implements IUsers{

    private EntityManager em;

    public UsersImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommercePU");
        em = emf.createEntityManager();
    }

    @Override
    public int add(Users user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Users user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
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
            em.remove(em.find(Users.class, id));
            em.getTransaction().commit();
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Users get(int id) {
        return em.find(Users.class, id);
    }

    @Override
    public List<Users> getAll() {
        try {
            //return em.createQuery("SELECT u FROM User u").getResultList();
            return em.createNamedQuery("user.all").getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users login(String username, String password) {
        try {
            return (Users) em.createNamedQuery("user.logon")
                    .setParameter("email", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

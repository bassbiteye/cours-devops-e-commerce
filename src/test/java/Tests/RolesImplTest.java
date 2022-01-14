package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import sn.isi.ecommerce.dao.IRoles;
import sn.isi.ecommerce.dao.IUsers;
import sn.isi.ecommerce.dao.RolesImpl;
import sn.isi.ecommerce.dao.UsersImpl;
import sn.isi.ecommerce.entities.Roles;
import sn.isi.ecommerce.entities.Users;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RolesImplTest {

    @Test
    void add() {
        IRoles roledoa = new RolesImpl();

        Roles roles = new Roles();
        roles.setNom("ROLE_SUPADMIN");

        int result = roledoa.add(roles);
        System.out.println(result);
    }

    @Test
    void update() {
        IRoles roledao = new RolesImpl();
        Roles role = roledao.get(1);
        role.setNom("ROLE_ADMINS");
        int result = roledao.update(role);
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        List<Roles> listRole = new ArrayList<Roles>();
        IRoles roledao = new RolesImpl();
        listRole = roledao.getAll();

        for (Roles role : listRole
             ) {
            System.out.println("Nom :"+role.getNom());
        }
    }
}
package Tests;

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

class UsersImplTest {

    @Test
    void add() {
        IUsers userdao = new UsersImpl();
        Users user = new Users();
        user.setNom("Test");
        user.setPrenom("Test");
        user.setEmail("testd@gmail.com");
        user.setPassword("passer123");
        user.setEtat(1);

        List<Roles> rolesL = new ArrayList<Roles>();
        IRoles roledoa = new RolesImpl();
        Roles role1 = roledoa.get(2);
        rolesL.add(role1);
        user.setRoles(rolesL);

        int result =  userdao.add(user);
        System.out.println(result);
    }

    @Test
    void update() {
        IUsers userdao = new UsersImpl();
        Users user = userdao.get(1);
        user.setPassword("Passer221");
        int result = userdao.update(user);
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        List<Users> usersList = new ArrayList<Users>();
        IUsers userdao = new UsersImpl();
        usersList = userdao.getAll();

        for (Users user: usersList
             ) {
            System.out.println("Nom :"+user.getNom()+" Prenom : "+user.getPrenom());
        }
    }

    @Test
    void login() {
        IUsers userdao = new UsersImpl();
        String email = "exauce@gmail.com";
        String password = "passer221";

        Users usersession = new Users();
        usersession = userdao.login(email, password);

        if(usersession != null) {
            System.out.println("Vous êtes bien connecté "+usersession.getNom()+" "+usersession.getPrenom());
        }else{
            System.out.println("Login ou mot de passe incorrecte");
        }
    }
}
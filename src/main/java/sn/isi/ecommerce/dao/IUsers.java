package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Roles;
import sn.isi.ecommerce.entities.Users;

import java.util.List;

public interface IUsers {
    public int add(Users user);
    public int update(Users user);
    public int delete(int id);
    public Users get(int id);
    public List<Users> getAll();
    public Users login(String username, String password);
}

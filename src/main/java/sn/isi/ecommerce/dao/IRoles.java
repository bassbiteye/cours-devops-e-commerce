package sn.isi.ecommerce.dao;

import sn.isi.ecommerce.entities.Roles;

import java.util.List;

public interface IRoles {
    public int add(Roles role);
    public int update(Roles role);
    public int delete(int id);
    public Roles get(int id);
    public List<Roles> getAll();
}

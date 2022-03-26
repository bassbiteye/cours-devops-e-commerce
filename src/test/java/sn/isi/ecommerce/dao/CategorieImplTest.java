package sn.isi.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.entities.Categorie;

class CategorieImplTest {

	@Test
	void testAdd() {
        ICategorie categorieDao = new CategorieImpl();
        Categorie categorie = new Categorie();
        categorie.setLibelle("Bureau");
        int result = categorieDao.add(categorie);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
	}

	@Test
	void testUpdate() {
        ICategorie categorieDao = new CategorieImpl();
        Categorie categorie = categorieDao.get(1);
        categorie.setLibelle("Informatique");
        int result = categorieDao.update(categorie);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
	}

	@Test
	void testDelete() {
        ICategorie categorieDao = new CategorieImpl();
        int result = categorieDao.delete(1);
        if(result == 1)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
	}

	@Test
	void testGet() {
        ICategorie categorieDao = new CategorieImpl();
        Categorie categorie = categorieDao.get(1);
        if(categorie != null)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
	}

	@Test
	void testGetAll() {
        ICategorie categorieDao = new CategorieImpl();
        List<Categorie> categories = categorieDao.getAll();
        if(categories.size() > 0)
            System.out.println("List contains " + categories.size() + " categories");
        else
            System.out.println("List empty");
	}

}

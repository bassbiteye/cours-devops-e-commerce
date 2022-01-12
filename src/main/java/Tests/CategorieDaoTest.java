package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.entities.Categorie;

public class CategorieDaoTest {

	@Before
	public void beforeTest()
	{
		System.out.println("=========BEFORE==========");
	}
	
	@After
	public void afterTest()
	{
		System.out.println("=========AFTER==========");
		
	}
	
	@Test
	public void testAddCategorie()
	{
		ICategorie categorieDao = new CategorieImpl();
		Categorie categorie = new Categorie();
		categorie.setLibelle("Ordinateur");
		categorieDao.add(categorie);
		assertNotEquals(categorieDao.getAll().contains(categorie), categorie);
	}
	

	@Test
	public void testUpdateCategorie()
	{
		ICategorie categorieDao = new CategorieImpl();
		Categorie categorie = categorieDao.get(1);
		categorie.setLibelle("Ordinateur modifié");
		categorieDao.update(categorie);
		assertEquals(categorieDao.get(1).getLibelle(), "Ordinateur modifié");
	}
	

	@Test
	public void testDeleteCategorie()
	{
		ICategorie categorieDao = new CategorieImpl();
		categorieDao.delete(1);
		assertEquals(categorieDao.get(1), null);
	}
}

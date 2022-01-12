package sn.isi.ecommerce.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.entities.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ICategorie icategorie = new CategorieImpl();
		List<Categorie> categories = icategorie.getAll();
		request.setAttribute("categories", categories); // set la liste des catégories
		request.setAttribute("isModification", "false");
		String action = (request.getParameter("action") != null) ? request.getParameter("action") : "null";
		switch (action) {
		case "edit":
			editCategorie(request, response);
		case "delete":
			deleteCategorie(request, response);
			break;
		}
		request.getRequestDispatcher("WEB-INF/views/categorie/crudCategorie.jsp").forward(request, response);
	}
	
	private void editCategorie(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("isModification", "true"); // set la liste des catégories
		request.setAttribute("idCategorie", id); // set la liste des catégories

	}
	
	private void deleteCategorie(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		ICategorie icategorie = new CategorieImpl();
		icategorie.delete(id);
		List<Categorie> categories = icategorie.getAll();
		request.getRequestDispatcher("WEB-INF/views/categorie/crudCategorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICategorie icategorie = new CategorieImpl();
		String libelle = request.getParameter("libelle-categorie");
		// set les valeurs de catégorie
		Categorie categorie = new Categorie();
		categorie.setLibelle(libelle);
		icategorie.add(categorie);
		List<Categorie> categories = icategorie.getAll();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/views/categorie/crudCategorie.jsp").forward(request, response);
	}

}

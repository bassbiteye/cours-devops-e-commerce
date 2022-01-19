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
		request.setAttribute("ancienLibelle", "");
		String action = (request.getParameter("action") != null) ? request.getParameter("action") : "null";
		int id = ((request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0);

		if (action.equals("edit")) {
			editCategorie(request, response);
		}
		else if (action.equals("delete")) {
			deleteCategorie(request, response);
		}else {
			request.setAttribute("option", "gestionCategories");
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}


	}

	private void editCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICategorie icategorie = new CategorieImpl();
		Categorie categorie = icategorie.get(id);
		request.setAttribute("categorie", categorie);
		request.setAttribute("option", "gestionCategories");
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}
	

	private void deleteCategorie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICategorie icategorie = new CategorieImpl();
		icategorie.delete(id);
		response.sendRedirect("http://localhost:8080/gestion-ecommerce/CategorieServlet");
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
		request.setAttribute("option", "gestionCategories");
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

}

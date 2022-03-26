package sn.isi.ecommerce.controllers;


import sn.isi.ecommerce.dao.FournisseurImpl;
import sn.isi.ecommerce.dao.IFournisseur;
import sn.isi.ecommerce.entities.Fournisseur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FournisseurSevlet")
public class FournisseurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FournisseurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void editFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IFournisseur ifournisseur = new FournisseurImpl();
        Fournisseur fournisseur = ifournisseur.get(id);
        request.setAttribute("fournisseur", fournisseur);
        request.setAttribute("option", "gestionFournisseurs");

        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }


    private void deleteFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IFournisseur ifournisseur = new FournisseurImpl();
        ifournisseur.delete(id);
        request.setAttribute("option", "gestionFournisseurs");
       // response.sendRedirect("http://localhost:8080/gestion-ecommerce/FournisseurServlet");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        IFournisseur iFournisseur = new FournisseurImpl();
        List<Fournisseur> fournisseurs = iFournisseur.getAll();
        request.setAttribute("fournisseurs", fournisseurs); // set la liste des fournisseurs
        request.setAttribute("option", "gestionFournisseurs");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

}

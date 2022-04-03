package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.FactureImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.dao.IFacturation;
import sn.isi.ecommerce.entities.Categorie;
import sn.isi.ecommerce.entities.Facturation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FacturationServlet")
public class FacturationServlet extends HttpServlet {
    private Facturation facture = new Facturation();
    public FacturationServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IFacturation iFacturation = new FactureImpl();
        List<Facturation> facturations = iFacturation.getAllFacture();
        request.setAttribute("factures", facturations); // set la liste des catégories
        request.setAttribute("isModification", "false");

        request.getRequestDispatcher("WEB-INF/views/categorie/crudCategorie.jsp").forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

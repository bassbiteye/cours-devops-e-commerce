package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.IProduit;
import sn.isi.ecommerce.dao.ProduitImpl;
import sn.isi.ecommerce.entities.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletListProd", value = "/ServletListProd")
public class ServletListProd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      IProduit prduitdao = new ProduitImpl();
        List<Produit> produit= prduitdao.getAll();
        request.setAttribute("produit",produit);
        request.setAttribute("option", "gestionProduitacceuil");
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

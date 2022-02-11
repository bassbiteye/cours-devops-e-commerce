package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.*;
import sn.isi.ecommerce.entities.Produit;
import sn.isi.ecommerce.entities.Roles;
import sn.isi.ecommerce.entities.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStock istock = new StockImpl();
        IProduit iProduit = new ProduitImpl();
        List<Stock> stocks = istock.getAll();
        List<Produit> produits = iProduit.getAll();
        request.setAttribute("stocks", stocks); // set la liste des stocks
        request.setAttribute("produits", produits); // set la liste des produits
        request.setAttribute("option", "gestionStocks");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStock istock = new StockImpl();
        IProduit iProduit = new ProduitImpl();
        // set les valeurs de catégorie
        Stock stock = new Stock();
        stock.setQte(Integer.parseInt(request.getParameter("quqntite")));
        int idProd = Integer.parseInt(request.getParameter("idProduit"));
        Produit p = iProduit.get(idProd);
        stock.setProduit(p);
        istock.add(stock);
        List<Stock> stocks = istock.getAll();
        request.setAttribute("stocks", stocks);
        request.setAttribute("option", "gestionStocks");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }
}

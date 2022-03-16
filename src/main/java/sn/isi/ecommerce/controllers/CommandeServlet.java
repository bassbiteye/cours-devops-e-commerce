package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.CommandeImpl;
import sn.isi.ecommerce.dao.ICommande;
import sn.isi.ecommerce.entities.Commande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("CommandeServlet")
public class CommandeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICommande iCommande = new CommandeImpl();
        List<Commande> commandes = iCommande.getAllCommande();
        request.setAttribute("commandes",commandes);
        request.getRequestDispatcher("WEB-INF/views/commande/crudCommande.jsp").forward(request,response);
    }
    private  void deleteCategorie(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        ICommande iCommande = new CommandeImpl();
        iCommande.deleteCommande(id);
        List<Commande> commandes = iCommande.getAllCommande();
        request.getRequestDispatcher("WEB-INF/views/commande/crudCommande.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICommande iCommande = new CommandeImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Commande commande = new Commande();
        commande.setId(id);
        iCommande.addCommande(commande);
        List<Commande> commandes = iCommande.getAllCommande();
        request.setAttribute("commandes",commandes);
        request.getRequestDispatcher("WEB-INF/views/commande/crudCommande.jsp").forward(request,response);

    }
}

package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.ILivraison;
import sn.isi.ecommerce.dao.LivraisonImp;
import sn.isi.ecommerce.entities.Commande;
import sn.isi.ecommerce.entities.Livraison;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LivraisonServlet")
public class LivraisonServlet extends HttpServlet {

    private Livraison livraison = new Livraison();
    public LivraisonServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        ILivraison iLivraison = new LivraisonImp();

        String livraison = request.getParameter("id");

        // set les valeurs de livraison

        Commande command = new Commande();
        command.setLivraison(iLivraison.get(livraison));
        iLivraison.saveLivraison(command);
        request.setAttribute("livraison", livraison);


    }
}
package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.*;
import sn.isi.ecommerce.entities.Categorie;
import sn.isi.ecommerce.entities.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletProduit", value = "/ServletProduit")
public class ServletProduit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProduit iProduit = new ProduitImpl();
        List<Produit> produits = iProduit.getAll();
        ICategorie icategorie = new CategorieImpl();
        List<Categorie> categories = icategorie.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("produits", produits); // set la liste des catégories
        request.setAttribute("isModification", "false");
        request.setAttribute("option", "gestionProduits");
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "null";
        switch (action) {
            case "edit":
                editProduit(request, response);
            case "delete":
               deleteProduit(request, response);
                break;
        }
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);

    }
    private void editProduit(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("isModification", "true"); // set la liste des catégories
        request.setAttribute("idProduit", id); // set la liste des catégories

    }

    private void deleteProduit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        IProduit iProduit = new ProduitImpl();
        iProduit.delete(id);
        List<Produit> produits = iProduit.getAll();
        request.getRequestDispatcher("WEB-INF/views/gestionProduit/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProduit iProduit = new ProduitImpl();
        Date dateperemtion = null;
     try {
            dateperemtion = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));
        } catch (ParseException e) {

            e.printStackTrace();
        }
        //String libelle = request.getParameter("libelle-produit");
        // set les valeurs de catégorie
        ICategorie iCategorie = new CategorieImpl();
        IUsers iUsers = new UsersImpl();
       // IUsers iUsers = new UsersImpl();
        Produit produit = new Produit();
        produit.setLibelle(request.getParameter("libelle"));
        produit.setDescription(request.getParameter("description"));
        //produit.setPhoto(request.getParameter("image"));
        produit.setPrixUnitaire(Integer.parseInt(request.getParameter("pu")));
        produit.setQuantite(Integer.parseInt(request.getParameter("qtts")));
        //produit.setQuantiteStock(Double.parseDouble(request.getParameter("qttst")));
        produit.setDateDePeremption(dateperemtion);
        int cat=Integer.parseInt(request.getParameter("idCategorie"));
        produit.setCategorie(iCategorie.get(cat));
        //produit.setUser(iUsers.get(1));
        iProduit.add(produit);
        List<Produit> produits = iProduit.getAll();
        request.setAttribute("produits", produits);
        ICategorie icategorie = new CategorieImpl();
        List<Categorie> categories = icategorie.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("option", "gestionProduitadd");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);


    }
}

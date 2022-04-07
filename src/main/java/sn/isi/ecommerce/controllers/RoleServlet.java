package sn.isi.ecommerce.controllers;

import java.io.IOException;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.isi.ecommerce.dao.IRoles;
import sn.isi.ecommerce.dao.RolesImpl;
import sn.isi.ecommerce.entities.Roles;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        IRoles irole = new RolesImpl();
        List<Roles> roles = irole.getAll();
        request.setAttribute("roles", roles); // set la liste des catégories
        request.setAttribute("isModification", "false");
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "null";
        int id = ((request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0);

        if (action.equals("edit")) {
            editRole(request, response);
        }
        else if (action.equals("delete")) {
            deleteRole(request, response);
        }else {
            request.setAttribute("option", "gestionRoles");
            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
        }


    }

    private void editRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IRoles irole = new RolesImpl();
        Roles role = irole.get(id);
        request.setAttribute("role", role);
        request.setAttribute("option", "gestionRoles");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }


    private void deleteRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IRoles irole = new RolesImpl();
        irole.delete(id);
        response.sendRedirect("http://localhost:8080/gestion-ecommerce/RoleServlet");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        IRoles irole = new RolesImpl();
        String nom = request.getParameter("libelle-role");
        // set les valeurs de catégorie
        Roles role = new Roles();
        role.setNom(nom);
        irole.add(role);
        List<Roles> roles = irole.getAll();
        request.setAttribute("roles", roles);
        request.setAttribute("option", "gestionRoless");
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

}

package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.CategorieImpl;
import sn.isi.ecommerce.dao.ICategorie;
import sn.isi.ecommerce.dao.IUser;
import sn.isi.ecommerce.dao.UserImpl;
import sn.isi.ecommerce.entities.Categorie;
import sn.isi.ecommerce.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUser iuser = new UserImpl();
        List<User> users = iuser.getAll();
        request.setAttribute("users", users); // set la liste des catégories
        request.setAttribute("isModification", "false");
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "null";
        switch (action) {
            case "edit":
                editUser(request, response);
            case "delete":
                deleteUser(request, response);
                break;
        }
        request.getRequestDispatcher("WEB-INF/views/user/crudUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUser iuser = new UserImpl();
        String libelle = request.getParameter("libelle-categorie");
        // set les valeurs de catégorie
        User user = new User();
        //user.set(libelle);
        iuser.add(user);
        List<User> users = iuser.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("WEB-INF/views/user/crudUser.jsp").forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("isModification", "true"); // set la liste des USERS
        request.setAttribute("idUser", id); // set la liste des users

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        IUser iuser = new UserImpl();
        iuser.delete(id);
        List<User> users = iuser.getAll();
        request.getRequestDispatcher("WEB-INF/views/user/crudUser.jsp").forward(request, response);
    }
}

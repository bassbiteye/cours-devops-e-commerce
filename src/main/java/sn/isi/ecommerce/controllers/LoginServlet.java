package sn.isi.ecommerce.controllers;

import sn.isi.ecommerce.dao.IUsers;
import sn.isi.ecommerce.dao.UsersImpl;
import sn.isi.ecommerce.entities.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUsers userdao;

    public LoginServlet() {
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        userdao = new UsersImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        HttpSession session = request.getSession();

        Users user = userdao.login(email, password);
        //response.getWriter().print(user);
        if (user != null) {
            session.setAttribute("user_session", user);
            response.getWriter().print(user.getNom());
            //response.sendRedirect("Accueil");
        } else {
            response.sendRedirect("Login");
        }
    }
}

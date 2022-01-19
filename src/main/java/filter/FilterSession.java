package filter;

import sn.isi.ecommerce.entities.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class FilterSession implements Filter {

    public FilterSession() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user_session");
        String chemin = req.getServletPath();

        if(user != null || chemin.equals("/") || chemin.equals("/Login")|| chemin.equals("/index.jsp") || chemin.startsWith("/public")) {
            chain.doFilter(request, response);
        }else {
            res.sendRedirect("Login");
        }
    }
}

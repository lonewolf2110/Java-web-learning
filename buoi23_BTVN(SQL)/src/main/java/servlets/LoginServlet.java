package servlets;

import auth.Authorizer;
import auth.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = 0;

        try (Authorizer auth = new Authorizer()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserEntity user = auth.login(username, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("fullName", user.getFullName());
                session.setAttribute("address", user.getAddress());
                System.out.println("login ok");
                response.sendRedirect(request.getContextPath() + "/");
                return;
            } else {
                status = 401;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = 500;
        }

        response.sendRedirect(request.getContextPath() + "/login?status=" + status);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.sendRedirect("/");
            return;
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }
}

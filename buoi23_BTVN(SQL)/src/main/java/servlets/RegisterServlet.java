package servlets;

import auth.Authorizer;
import auth.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = 0;

        try (Authorizer auth = new Authorizer()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String fullName = request.getParameter("fullName");
            String address = request.getParameter("address");

            Status stt = auth.register(username, password, email, fullName, address);

            if (stt == Status.SUCCESS) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("email", email);
                session.setAttribute("fullName", fullName);
                session.setAttribute("address", address);
                response.sendRedirect(request.getContextPath() + "/");
                return;
            } else {
                status = 403;
            }
        } catch (Exception e) {
            status = 500;
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/register?status=" + status);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }
}

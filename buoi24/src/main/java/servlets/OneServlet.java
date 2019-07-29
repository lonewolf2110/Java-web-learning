package servlets;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "OneServlet", urlPatterns = {"/1"})
public class OneServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("hihi", "haha");
        getServletContext().getRequestDispatcher("/WEB-INF/1.jsp").include(request, response);
    }
}

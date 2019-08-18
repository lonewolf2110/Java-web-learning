package controllers;

import models.StudentEntity;
import models.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateServlet", urlPatterns = {"/create"})
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String className = request.getParameter("class");
        String address = request.getParameter("address");
        float score = Float.parseFloat(request.getParameter("score"));

        StudentEntity student = new StudentEntity(fullName, className, address, score);
        StudentModel model = new StudentModel();
        try {
            model.create(student);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
}

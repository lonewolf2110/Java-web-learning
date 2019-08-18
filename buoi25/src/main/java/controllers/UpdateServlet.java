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

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String fullName = request.getParameter("full_name");
            String className = request.getParameter("class");
            String address = request.getParameter("address");
            float score = Float.parseFloat(request.getParameter("score"));

            StudentEntity student = new StudentEntity(id, fullName, className, address, score);
            StudentModel model = new StudentModel();
            model.update(student);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            StudentModel model = new StudentModel();
            StudentEntity student = model.read(id);
            request.setAttribute("student", student);
            getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}

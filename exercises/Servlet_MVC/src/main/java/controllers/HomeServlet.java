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
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = {"/", "/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentModel model = new StudentModel();
        List<StudentEntity> studentEntityList = null;

        try {
            studentEntityList = model.readAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("studentList", studentEntityList);
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }
}

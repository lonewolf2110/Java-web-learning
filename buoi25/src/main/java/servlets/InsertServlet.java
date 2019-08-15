package servlets;

import db.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InsertServlet", urlPatterns = {"/insert"})
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String major = request.getParameter("major");
            String classname = request.getParameter("class");

            Connection conn = MySQLConnector.connect("java_web_learning", "root", "");
            String query = "INSERT INTO SinhVien( name, major, class) VALUES ( ?, ?, ? )";
            PreparedStatement prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, name);
            prepStatement.setString(2, major);
            prepStatement.setString(3, classname);
            prepStatement.executeUpdate();

            prepStatement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/insert.jsp").forward(request, response);
    }
}

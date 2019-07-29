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

@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Connection conn = MySQLConnector.connect("java_web_learning", "root", "");
            String query = "DELETE FROM SinhVien WHERE id = ?";
            PreparedStatement prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            prepStatement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

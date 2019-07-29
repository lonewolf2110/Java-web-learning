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

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection conn = MySQLConnector.connect("java_web_learning", "root", "");
            String col = request.getParameter("column");
            int id = Integer.parseInt(request.getParameter("id"));
            String newVal = request.getParameter("newValue");
            String query = String.format("UPDATE SinhVien SET %s = ? WHERE id = ?", col);
            PreparedStatement prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, newVal);
            prepStatement.setInt(2, id);
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

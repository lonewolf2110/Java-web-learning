package models;

import database.SQLConnector;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IModel<BookBean> {
    private static final String DATABASE = "java_web_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Override
    public int create(BookBean bean) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "INSERT INTO BookManager (title, author, price, quantity) VALUES(?, ?, ?, ?)";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, bean.getTitle());
        prepStmt.setString(2, bean.getAuthor());
        prepStmt.setBigDecimal(3, bean.getPrice());
        prepStmt.setInt(4, bean.getQuantity());
        int res = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

        return res;
    }

    @Override
    public BookBean read(int id) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "SELECT * FROM BookManager WHERE id=?";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setInt(1, id);
        ResultSet resultSet = prepStmt.executeQuery();
        List<BookBean> bookList = getBookList(resultSet);

        return bookList.get(0);
    }

    @Override
    public int update(BookBean bean) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "UPDATE BookManager SET title=?, author=?, price=?, quantity=? WHERE id=?";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, bean.getTitle());
        prepStmt.setString(2, bean.getAuthor());
        prepStmt.setBigDecimal(3, bean.getPrice());
        prepStmt.setInt(4, bean.getQuantity());
        prepStmt.setInt(5, bean.getId());
        int res = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

        return res;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "DELETE FROM BookManager WHERE id = ?";
        PreparedStatement prepStatement = conn.prepareStatement(query);
        prepStatement.setInt(1, id);
        int res = prepStatement.executeUpdate();
        prepStatement.close();
        conn.close();

        return res;
    }

    @Override
    public List<BookBean> readAll() throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "SELECT * FROM BookManager";
        PreparedStatement prepStatement = conn.prepareStatement(query);
        ResultSet resultSet = prepStatement.executeQuery();
        List<BookBean> bookBeanList = getBookList(resultSet);

        prepStatement.close();
        conn.close();

        return bookBeanList;
    }

    private List<BookBean> getBookList(ResultSet resultSet) throws SQLException {
        List<BookBean> bookList = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            BigDecimal price = resultSet.getBigDecimal("price");
            int quantity = resultSet.getInt("quantity");
            bookList.add(new BookBean(id, title, author, price, quantity));
        }

        return bookList;
    }

}

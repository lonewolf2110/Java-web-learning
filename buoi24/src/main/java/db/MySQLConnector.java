package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector{
    private static final String DB_URL = "jdbc:mysql://localhost:3306";

    public static Connection connect(String table, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dUrl = String.format("%s/%s", DB_URL, table);
        return DriverManager.getConnection(dUrl, username, password);
    }
}

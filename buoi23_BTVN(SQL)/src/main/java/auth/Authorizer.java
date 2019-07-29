package auth;

import db.MySQLConnector;

import java.sql.*;

public class Authorizer implements AutoCloseable{
    private static final String DB_NAME = "java_web_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection conn;

    public Authorizer() throws SQLException, ClassNotFoundException {
        this.conn = MySQLConnector.connect(DB_NAME, USERNAME, PASSWORD);
    }

    public Status register(String username, String password, String email, String fullName, String address) throws Exception {
        String query =
                "INSERT INTO buoi23(uname, upwd, email, fname, address) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, fullName);
            preparedStatement.setString(5, address);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return Status.SUCCESS;
        } catch (SQLException e) {

            if (1062 == e.getErrorCode()) {
                return Status.FAILED;
            } else {
                throw new Exception();
            }
        }

    }

    public UserEntity login(String username, String password) throws SQLException {
        Statement statement = conn.createStatement();
        String query = String.format(
                "SELECT * FROM buoi23 WHERE uname = '%s' AND upwd='%s'",
                username,
                password
        );
        ResultSet resultSet = statement
                .executeQuery(query);

        while (resultSet.next()) {
            int usid = resultSet.getInt("usid");
            String uname = resultSet.getString("uname");
            String upwd = resultSet.getString("upwd");
            String email = resultSet.getString("email");
            String fname = resultSet.getString("fname");
            String address = resultSet.getString("address");

            return new UserEntity(usid, uname, upwd, email, fname, address);
        }

        statement.close();

        return null;
    }



    @Override
    public void close() throws Exception {
        conn.close();
    }
}

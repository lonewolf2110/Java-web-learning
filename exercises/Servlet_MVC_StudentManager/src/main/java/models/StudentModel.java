package models;

import database.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IModel<StudentEntity> {
    private static final String DATABASE = "java_web_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Override
    public int create(StudentEntity entity) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "INSERT INTO SinhVien (full_name, class, address, score) VALUES(?, ?, ?, ?)";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, entity.getFullName());
        prepStmt.setString(2, entity.getClassName());
        prepStmt.setString(3, entity.getAddress());
        prepStmt.setFloat(4, entity.getScore());
        int res = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

        return res;
    }

    @Override
    public StudentEntity read(int id) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "SELECT * FROM SinhVien WHERE id=?";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setInt(1, id);
        ResultSet resultSet = prepStmt.executeQuery();
        List<StudentEntity> studentEntityList = getStudentList(resultSet);

        return studentEntityList.size() > 0 ? studentEntityList.get(0) : null;
    }

    @Override
    public int update(StudentEntity entity) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "UPDATE SinhVien SET full_name=?, class=?, address=?, score=? WHERE id=?";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, entity.getFullName());
        prepStmt.setString(2, entity.getClassName());
        prepStmt.setString(3, entity.getAddress());
        prepStmt.setFloat(4, entity.getScore());
        prepStmt.setInt(5, entity.getId());
        int res = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

        return res;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "DELETE FROM SinhVien WHERE id = ?";
        PreparedStatement prepStatement = conn.prepareStatement(query);
        prepStatement.setInt(1, id);
        int res = prepStatement.executeUpdate();
        prepStatement.close();
        conn.close();

        return res;
    }

    @Override
    public List<StudentEntity> readAll() throws SQLException, ClassNotFoundException {
        Connection conn = SQLConnector.connect(DATABASE, USERNAME, PASSWORD);
        String query = "SELECT * FROM SinhVien";
        PreparedStatement prepStatement = conn.prepareStatement(query);
        ResultSet resultSet = prepStatement.executeQuery();
        List<StudentEntity> studentEntityList = getStudentList(resultSet);

        prepStatement.close();
        conn.close();

        return studentEntityList;
    }

    private List<StudentEntity> getStudentList(ResultSet resultSet) throws SQLException {
        List<StudentEntity> studentEntityList = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("full_name");
            String className = resultSet.getString("class");
            String address = resultSet.getString("address");
            float score = resultSet.getFloat("score");
            studentEntityList.add(new StudentEntity(id, fullName, className, address, score));
        }

        return studentEntityList;
    }

}

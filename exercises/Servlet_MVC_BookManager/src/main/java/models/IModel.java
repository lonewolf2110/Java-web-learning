package models;

import java.sql.SQLException;
import java.util.List;

public interface IModel<T> {
    int create(T bean) throws SQLException, ClassNotFoundException;
    T read(int id) throws SQLException, ClassNotFoundException;
    int update(T bean) throws SQLException, ClassNotFoundException;
    int delete(int id) throws SQLException, ClassNotFoundException;
    List<T> readAll() throws SQLException, ClassNotFoundException;
}

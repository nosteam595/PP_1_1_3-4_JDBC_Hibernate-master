package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "lastName VARCHAR(100), " +
                "age TINYINT(3) NOT NULL DEFAULT 0" +
                ")";
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Таблица создана.");
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {
//        String insertNewUser = "INSERT INTO users (name, lastName, age) " +
//                "VALUES (" + name + ", " + lastName + ", " + age + ")";
//        String insertNewUser = "INSERT INTO users (name, lastName, age) VALUES ('name', 'lastName', age)";
//        Statement statement = Util.getConnection();
//        try {
//            statement.executeUpdate(insertNewUser);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Пользователь добавлен.");

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}

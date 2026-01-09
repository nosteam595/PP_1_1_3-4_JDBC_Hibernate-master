package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createUsersTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "lastName VARCHAR(100), " +
                "age TINYINT(3) NOT NULL DEFAULT 0" +
                ")";
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createUsersTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Таблица создана.");
    }

    public void dropUsersTable() {
        String dropUsersTableSQL = "DROP TABLE IF EXISTS users";
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(dropUsersTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Таблица удалена.");
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
        List<User> allUsers = new ArrayList<>();
        String getAllUsersSQL = "SELECT * FROM users";
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsersSQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Данные получены.");
        return allUsers;
    }

    public void cleanUsersTable() {

    }
}

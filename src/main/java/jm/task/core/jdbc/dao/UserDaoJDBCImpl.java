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
        PreparedStatement preparedStatement;
        String saveUserSql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        Connection connection = Util.getConnection();
        try {
            preparedStatement = connection.prepareStatement(saveUserSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User с именем - " + name + " добавлен в базу данных.");
    }

    public void removeUserById(long id) {
        PreparedStatement preparedStatement;
        String removeUserByIdSql = "DELETE FROM users WHERE id = ?";
        Connection connection = Util.getConnection();
        try {
            preparedStatement = connection.prepareStatement(removeUserByIdSql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Пользователь удалён.");
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
        String cleanUsersTableSql = "DELETE FROM users";
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(cleanUsersTableSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Таблица очищена.");
    }
}

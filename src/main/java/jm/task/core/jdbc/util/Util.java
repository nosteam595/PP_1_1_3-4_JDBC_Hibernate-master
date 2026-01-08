package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL80";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Statement getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            System.out.println("Успешное подключение к БД!");
            return statement;
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

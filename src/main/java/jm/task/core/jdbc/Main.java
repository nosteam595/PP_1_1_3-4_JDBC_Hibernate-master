package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Иван", "Иванович", (byte) 50);
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        //userDaoJDBC.saveUser("Иван", "Иванович", (byte) 50);
        userDaoJDBC.createUsersTable();



    }
}

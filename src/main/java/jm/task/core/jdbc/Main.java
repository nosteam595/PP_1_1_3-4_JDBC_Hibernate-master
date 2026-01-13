package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Петр", "П", (byte) 20);
        userService.saveUser("Василий", "В", (byte) 25);
        userService.saveUser("Иван", "И", (byte) 31);
        userService.saveUser("Егор", "Е", (byte) 38);

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

//        userService.removeUserById(3);
    }
}

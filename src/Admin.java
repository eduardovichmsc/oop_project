import java.util.*;

public class Admin extends Employee {

    public Admin(String id, String password, String firstName, String lastName, double salary, Date hireDate) {
        super(id, password, firstName, lastName, salary, hireDate);
    }

    // Добавление пользователя в систему
    public void addUser(List<User> systemUsers, User newUser) {
        if (!systemUsers.contains(newUser)) {
            systemUsers.add(newUser);
            System.out.println("Пользователь " + newUser.getFirstName() + " добавлен в систему.");
        } else {
            System.out.println("Ошибка: Такой пользователь уже существует.");
        }
    }

    // Удаление пользователя из системы
    public void removeUser(List<User> systemUsers, User userToRemove) {
        if (systemUsers.remove(userToRemove)) {
            System.out.println("Пользователь " + userToRemove.getFirstName() + " удален из системы.");
        } else {
            System.out.println("Ошибка: Пользователь не найден.");
        }
    }

    // Просмотр логов
    public void viewLogs(List<String> logFiles) {
        System.out.println("=== ЛОГИ СИСТЕМЫ ===");
        for (String log : logFiles) {
            System.out.println(log);
        }
        System.out.println("====================");
    }

    @Override
    public String toString() {
        return "Admin []";
    }
}
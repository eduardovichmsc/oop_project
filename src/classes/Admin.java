package classes;

import abstracts.Employee;
import abstracts.User;
import enums.RequestType;

public class Admin extends Employee {

    public Admin(int id, String login, String name, String surname, String email, double salary, String school) {
        super(id, login, name, surname, email, salary, school);
    }

    // methods
    public void addUser(User user) {
        System.out.println("Пользователь " + user.getLogin() + " добавлен в систему.");
    }

    public void removeUser(User user) {
        System.out.println("Пользователь " + user.getLogin() + " удален из системы.");
    }

    public void updateUser(User user) {
        System.out.println("Данные пользователя " + user.getLogin() + " обновлены.");
    }

    public void viewLogs() {
        System.out.println("Просмотр системных логов...");
    }

    // methods from User
    @Override
    public boolean login() {
        System.out.println("Администратор " + getFullName() + " вошел в систему.");
        return true;
    }

    @Override
    public boolean logout() {
        System.out.println("Администратор " + getFullName() + " вышел из системы.");
        return true;
    }

    @Override
    public void createRequest(RequestType type, String message) {
        System.out.println("Запрос от администратора (" + type + "): " + message);
    }
}
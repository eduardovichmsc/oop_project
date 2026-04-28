package classes;

import abstracts.Employee;
import enums.RequestType;
import java.util.List;
import java.util.ArrayList;

public class TechSupport extends Employee {

    public TechSupport(int id, String login, String name, String surname, String email, double salary, String school) {
        super(id, login, name, surname, email, salary, school);
    }

    // methods
    public List<Request> viewTechRequests() {
        System.out.println("Просмотр технических запросов...");
        return new ArrayList<>();
    }

    public void resolveRequest(Request request) {
        System.out.println("Технический запрос решен: " + request.getTopic());
        request.setResolved(true);
    }

    // methods from User
    @Override
    public boolean login() {
        System.out.println("Специалист техподдержки " + getFullName() + " вошел в систему.");
        return true;
    }

    @Override
    public boolean logout() {
        System.out.println("Специалист техподдержки " + getFullName() + " вышел из системы.");
        return true;
    }

    @Override
    public void createRequest(RequestType type, String message) {
        System.out.println("Запрос от техподдержки (" + type + "): " + message);
    }
}
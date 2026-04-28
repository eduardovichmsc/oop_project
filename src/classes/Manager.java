package classes;

import abstracts.Employee;
import enums.ManagerType;
import enums.RequestType;
import java.util.List;
import java.util.ArrayList;

public class Manager extends Employee {
    private ManagerType managerType;

    public Manager(int id, String login, String name, String surname, String email, double salary, String school, 
                   ManagerType managerType) {
        super(id, login, name, surname, email, salary, school);
        this.managerType = managerType;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    // methods
    public Object createStatisticReport() {
        System.out.println("Создание статистического отчета...");
        return new Object(); 
    }

    public void assignCourseToTeacher() {
        System.out.println("Курс назначен преподавателю.");
    }

    public void approveRegistration(Request request) {
        System.out.println("Регистрация одобрена для запроса: " + request.getTopic());
        request.setResolved(true);
    }

    public void openRegistration(Object course) {
        System.out.println("Регистрация на курс открыта.");
    }

    public void publishNews(String news) {
        System.out.println("Опубликована новость: " + news);
    }

    public void manageNews() {
        System.out.println("Управление новостями...");
    }

    public List<Request> viewAcademicRequests() {
        System.out.println("Просмотр академических запросов...");
        return new ArrayList<>();
    }

    // methods from User
    @Override
    public boolean login() {
        System.out.println("Менеджер " + getFullName() + " вошел в систему.");
        return true;
    }

    @Override
    public boolean logout() {
        System.out.println("Менеджер " + getFullName() + " вышел из системы.");
        return true;
    }

    @Override
    public void createRequest(RequestType type, String message) {
        System.out.println("Запрос от менеджера (" + type + "): " + message);
    }
}
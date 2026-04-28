package classes;

import abstracts.Employee;
import abstracts.Student;
import enums.TeacherTitle;
import enums.RequestType;
import java.io.File;

public class Teacher extends Employee {
    private String teacherId;
    private TeacherTitle title;
    private double rating;

    public Teacher(int id, String login, String name, String surname, String email, double salary, String school, 
                   String teacherId, TeacherTitle title, double rating) {
        super(id, login, name, surname, email, salary, school);
        this.teacherId = teacherId;
        this.title = title;
        this.rating = rating;
    }

    // getters & setters
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // methods
    public void viewCourses() {
        System.out.println("Просмотр курсов преподавателя...");
    }

    public void putMark(Student student, Object mark) {
        System.out.println("Оценка выставлена студенту: " + student.getFullName());
    }

    public void uploadCourseMaterials(Object course, File file) {
        System.out.println("Материалы загружены для курса.");
    }

    public void removeCourseMaterials() {
        System.out.println("Материалы курса удалены.");
    }

    public void removeStudentFromCourse(Student student) {
        System.out.println("Студент " + student.getFullName() + " удален с курса.");
    }

    public void markAttendance() {
        System.out.println("Посещаемость отмечена.");
    }

    public void putFinalExamMark() {
        System.out.println("Итоговая оценка за экзамен выставлена.");
    }

    // methods from User
    @Override
    public boolean login() {
        System.out.println("Преподаватель " + getFullName() + " вошел в систему.");
        return true; 
    }
    @Override
    public boolean logout() {
        System.out.println("Преподаватель " + getFullName() + " вышел из системы.");
        return true;
    }
    @Override
    public void createRequest(RequestType type, String message) {
        System.out.println("Запрос типа " + type + " создан преподавателем: " + message);
    }
}
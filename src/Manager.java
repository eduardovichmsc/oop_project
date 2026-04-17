import java.util.*;

public class Manager extends Employee {
    private ManagerType type;

    public Manager(String id, String password, String firstName, String lastName, double salary, Date hireDate, ManagerType type) {
        super(id, password, firstName, lastName, salary, hireDate);
        this.type = type;
    }
    
    // Управление курсами и студентами

    // Назначение курса преподавателю
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher);
        teacher.addCourse(course);
        System.out.println("Курс " + course.getCourseName() + " успешно назначен преподавателю " + teacher.getLastName());
    }

    // Одобрение регистрации студента
    public void approveStudentRegistration(Student student, Course course) {
        System.out.println("Менеджер " + getLastName() + " одобрил регистрацию студента " + student.getLastName() + " на курс " + course.getCourseName());
    }

    // Отчеты и просмотр информаций

    // Создание простого статистического отчета об успеваемости
    public void createStatisticalReport(List<Student> allStudents) {
        System.out.println("=== СТАТИСТИЧЕСКИЙ ОТЧЕТ ОБ УСПЕВАЕМОСТИ ===");
        int totalStudents = allStudents.size();
        int failedStudents = 0;

        for (Student s : allStudents) {
            // Если у студента больше 3 провалов, считаем его неуспевающим
            if (s.getFailCount() > 3) {
                failedStudents++;
            }
        }
        
        System.out.println("Всего студентов: " + totalStudents);
        System.out.println("Студентов на отчисление (>3 провалов): " + failedStudents);
        System.out.println("============================================");
    }

    // Просмотр студентов с сортировкой
    public void viewStudentsSorted(List<Student> students, Comparator<Student> comparator) {
        Collections.sort(students, comparator);
        System.out.println("--- Список студентов ---");
        for (Student s : students) {
            System.out.println(s.getLastName() + " " + s.getFirstName() + " (Курс: " + s.getYearOfStudy() + ")");
        }
    }

    public ManagerType getType() {
        return type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Manager other = (Manager) obj;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Manager [type=" + type + "]";
    }
}
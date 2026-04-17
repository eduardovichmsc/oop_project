import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Начало ===");

        // Инициализация юзеров и бд
        List<User> systemUsers = new ArrayList<>();
        
        Manager manager = new Manager("m1", "pass123", "Alice", "Smith", 50000, new Date(), ManagerType.OR);
        Admin admin = new Admin("a1", "admin123", "Bob", "Johnson", 60000, new Date());
        Teacher profTuring = new Teacher("t1", "turing123", "Alan", "Turing", 100000, new Date(), TeacherTitle.PROFESSOR, true);
        Student studentFreshman = new Student("s1", "pass", "John", "Doe", 1, "Computer Science");
        Student studentSenior = new Student("s2", "pass", "Jane", "Doe", 4, "Computer Science");
        
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(studentFreshman);
        allStudents.add(studentSenior);

        System.out.println("--- Часть с Админ ---");
        admin.addUser(systemUsers, manager);
        admin.addUser(systemUsers, profTuring);
        admin.addUser(systemUsers, profTuring); 

        // Учебный процесс
        Course javaOOP = new Course("CS201", "Object Oriented Programming", 3, "Computer Science", 2);
        Course heavyMath = new Course("MATH300", "Advanced Calculus", 20, "Mathematics", 2);
        
        manager.assignCourseToTeacher(javaOOP, profTuring);

        System.out.println("--- Регистрация на курсы / Лимит кредитов ---");
        // +3 кредита - успешно
        studentFreshman.registerForCourse(javaOOP); 
        // Проверка ошибки лимита - максимум 21 кредит
        studentFreshman.registerForCourse(heavyMath);

        System.out.println("--- Выставление оценок ---");
        studentSenior.registerForCourse(javaOOP);
        profTuring.putMark(javaOOP, studentFreshman, 30.0, 25.0, 40.0);
        profTuring.putMark(javaOOP, studentSenior, 10.0, 15.0, 20.0);

        System.out.println("--- Часть с Research ---");
        ResearchPaper aiPaper = new ResearchPaper("Computing Machinery", null, "Mind", 30, new Date(), "doi.1", 15000);
        ResearchPaper mathPaper = new ResearchPaper("On Computable Numbers", null, "LMS", 45, new Date(), "doi.2", 25000);
        
        profTuring.addResearchPaper(aiPaper);
        profTuring.addResearchPaper(mathPaper);

        // Сортировка статей по количеству цитирований
        Comparator<ResearchPaper> citationComparator = new Comparator<ResearchPaper>() {
            @Override
            public int compare(ResearchPaper p1, ResearchPaper p2) {
                return Integer.compare(p2.getCitations(), p1.getCitations());
            }
        };
        
        System.out.println("Вывод статей профессора Тьюринга (сортировка по цитированиям):");
        profTuring.printPapers(citationComparator);

        // Тест исключений
        System.out.println("--- Исключения - Exceptions ---");
        
        // Низкий h-index
        try {
            System.out.println("Попытка назначить руководителя с h-index < 3...");
            studentSenior.setSupervisor(profTuring); 
        } catch (LowHIndexException e) {
            System.out.println("❌ Ошибка перехвачена: " + e.getMessage());
        }

        // Добавление в проект не-исследователя
        ResearchProject turingProject = new ResearchProject("Artificial Intelligence Engine");
        try {
            System.out.println("Попытка добавить профессора в научный проект...");
            // Успешно
            turingProject.addParticipant(profTuring); 
            
            System.out.println("Попытка добавить первокурсника (не исследователя) в научный проект...");
            // Тест на ошибку
            turingProject.addParticipant(studentFreshman); 
        } catch (NotAResearcherException e) {
            System.out.println("❌ Ошибка перехвачена: " + e.getMessage());
        }

        // Менеджер
        System.out.println("--- Отчеты ---");
        studentFreshman.incrementFailCount();
        studentFreshman.incrementFailCount();
        studentFreshman.incrementFailCount();
        // > 3 провалов
        studentFreshman.incrementFailCount();

        manager.createStatisticalReport(allStudents);

        System.out.println("=== Конец ===");
    }
}
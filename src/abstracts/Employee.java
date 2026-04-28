package abstracts;

public abstract class Employee extends User {
    protected double salary;
    protected String school;

    public Employee(int id, String login, String name, String surname, String email, double salary, String school) {
        super(id, login, name, surname, email);
        this.salary = salary;
        this.school = school;
    }

    // getters & setters
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    
    // methods
    // public void sendMessage() {}
    // public void sendRequest() {}
}
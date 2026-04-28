package abstracts;

public abstract class Student extends User {
    protected String studentId;
    protected int year;
    protected String major;
    protected double gpa;
    protected int credits;
    protected int failedCourseCount;

    public Student(int id, String login, String name, String surname, String email, String studentId, int year, String major, double gpa, int credits, int failedCourseCount) {
        super(id, login, name, surname, email); 
        this.studentId = studentId;
        this.year = year;
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        this.failedCourseCount = failedCourseCount;
    }

    // getters & setters
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public int getFailedCourseCount() {
        return failedCourseCount;
    }
    public void setFailedCourseCount(int failedCourseCount) {
        this.failedCourseCount = failedCourseCount;
    }
    
    // methods
    // public abstract void registerForCourse(Course course);
    public abstract void viewCourses();
    public abstract void viewMarks();
    public abstract Object getTranscript();
    // public abstract void sendCourseAddRequest(Course course);
}
import java.util.*;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private List<Teacher> instructors;
    private String majorIntended;
    private int yearOfStudyIntended;

    public Course(String courseCode, String courseName, int credits, String majorIntended, int yearOfStudyIntended) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.majorIntended = majorIntended;
        this.yearOfStudyIntended = yearOfStudyIntended;
        this.instructors = new ArrayList<>(); 
    }

    public void addInstructor(Teacher teacher) {
        if (!instructors.contains(teacher)) {
            instructors.add(teacher);
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Teacher> instructors) {
        this.instructors = instructors;
    }

    public String getMajorIntended() {
        return majorIntended;
    }

    public void setMajorIntended(String majorIntended) {
        this.majorIntended = majorIntended;
    }

    public int getYearOfStudyIntended() {
        return yearOfStudyIntended;
    }

    public void setYearOfStudyIntended(int yearOfStudyIntended) {
        this.yearOfStudyIntended = yearOfStudyIntended;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public String toString() {
        return "Course{" + "courseCode='" + courseCode + '\'' + ", courseName='" + courseName + '\'' + '}';
    }
}
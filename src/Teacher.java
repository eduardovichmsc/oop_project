import java.util.*;

public class Teacher extends Employee implements Researcher {
    private TeacherTitle title; 
    private List<Course> coursesTaught;
    private double rating;
    private int ratingVotesCount; 
    
    private boolean isResearcher;
    private List<ResearchPaper> researchPapers;

    
    public Teacher(String id, String password, String firstName, String lastName, double salary, Date hireDate, TeacherTitle title, boolean wantsToBeResearcher) {
        super(id, password, firstName, lastName, salary, hireDate); 
        this.title = title;
        this.rating = 0.0;
        this.ratingVotesCount = 0;
        
        this.coursesTaught = new ArrayList<>();
        this.researchPapers = new ArrayList<>();

        if (title == TeacherTitle.PROFESSOR) {
            this.isResearcher = true;
        } else {
            this.isResearcher = wantsToBeResearcher;
        }
    }

    // Учеба и оценки

    // Выставление оценки студенту
    public void putMark(Course course, Student student, double att1, double att2, double finalEx) {
        // Проверка: ведет ли этот преподаватель данный курс
        if (!coursesTaught.contains(course)) {
            System.out.println("Ошибка: Преподаватель " + getLastName() + " не ведет курс " + course.getCourseName());
            return;
        }

        // Проверка: зарегистрирован ли студент на этот курс
        if (!student.getTranscript().containsKey(course)) {
            System.out.println("Ошибка: Студент " + student.getLastName() + " не зарегистрирован на этот курс.");
            return;
        }

        // Получаем объект Mark студента по этому курсу и обновляем баллы
        Mark studentMark = student.getTranscript().get(course);
        studentMark.setFirstAttestation(att1);
        studentMark.setSecondAttestation(att2);
        studentMark.setFinalExam(finalEx);

        System.out.println("Оценки успешно выставлены студенту " + student.getLastName());
    }

    // Метод для добавления курса преподавателю
    public void addCourse(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
        }
    }

    // Метод для обновления рейтинга преподавателя студентами
    public void updateRating(double newRatingVote) {
        if (newRatingVote >= 0 && newRatingVote <= 5) {
            this.ratingVotesCount++;
            this.rating = ((this.rating * (this.ratingVotesCount - 1)) + newRatingVote) / this.ratingVotesCount;
        }
    }

    // Researcher

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        if (isResearcher) {
            this.researchPapers.add(paper);
        } else {
            System.out.println("Ошибка: Этот преподаватель не занимается наукой.");
        }
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return this.researchPapers;
    }

    @Override
    public int getHIndex() {
        if (!isResearcher) return 0;
        return this.researchPapers.size();
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        if (!isResearcher) {
            System.out.println("Этот преподаватель не занимается наукой.");
            return;
        }
        Collections.sort(this.researchPapers, comparator);
        System.out.println("--- Научные статьи преподавателя " + getLastName() + " ---");
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.toString());
        }
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingVotesCount() {
        return ratingVotesCount;
    }

    public void setRatingVotesCount(int ratingVotesCount) {
        this.ratingVotesCount = ratingVotesCount;
    }

    public boolean isResearcher() {
        return isResearcher;
    }

    public void setResearcher(boolean isResearcher) {
        this.isResearcher = isResearcher;
    }

    public void setResearchPapers(List<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((coursesTaught == null) ? 0 : coursesTaught.hashCode());
        long temp;
        temp = Double.doubleToLongBits(rating);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ratingVotesCount;
        result = prime * result + (isResearcher ? 1231 : 1237);
        result = prime * result + ((researchPapers == null) ? 0 : researchPapers.hashCode());
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
        Teacher other = (Teacher) obj;
        if (title != other.title)
            return false;
        if (coursesTaught == null) {
            if (other.coursesTaught != null)
                return false;
        } else if (!coursesTaught.equals(other.coursesTaught))
            return false;
        if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
            return false;
        if (ratingVotesCount != other.ratingVotesCount)
            return false;
        if (isResearcher != other.isResearcher)
            return false;
        if (researchPapers == null) {
            if (other.researchPapers != null)
                return false;
        } else if (!researchPapers.equals(other.researchPapers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name='" + getFirstName() + " " + getLastName() + '\'' + ", title=" + title + '}';
    }
}
import java.util.*;

public class Student extends User implements Researcher {
    private int yearOfStudy;
    private int credits;
    private int failCount;
    private String major;
    private Researcher supervisor;
    
    private Map<Course, Mark> transcript;
    
    private List<ResearchPaper> researchPapers;

    public Student(String id, String password, String firstName, String lastName, int yearOfStudy, String major) {
        super(id, password, firstName, lastName);
        this.yearOfStudy = yearOfStudy;
        this.major = major;
        this.credits = 0;  
        this.failCount = 0;
        
        this.transcript = new HashMap<>();
        this.researchPapers = new ArrayList<>();
    }
    
    // Учеба
    public void registerForCourse(Course course) {
        if (this.credits + course.getCredits() > 21) {
            System.out.println("Ошибка: Студент не может взять больше 21 кредита!");
        } else {
            this.transcript.put(course, new Mark());
            this.credits += course.getCredits();
            System.out.println("Регистрация успешна. Текущее количество кредитов: " + this.credits);
        }
    }

    public void incrementFailCount() {
        this.failCount++;
        if (this.failCount > 3) {
            System.out.println("ВНИМАНИЕ: Студент " + getFirstName() + " провалил больше 3 курсов и подлежит отчислению!");
        }
    }

    public void setSupervisor(Researcher supervisor) throws LowHIndexException {
        if (this.yearOfStudy != 4) {
            System.out.println("Ошибка: Научный руководитель положен только студентам 4 курса.");
            return;
        }
        
        if (supervisor.getHIndex() < 3) {
            throw new LowHIndexException("Невозможно назначить! H-index руководителя меньше 3.");
        }
        
        this.supervisor = supervisor;
        System.out.println("Научный руководитель успешно назначен.");
    }

    // Researcher
    @Override
    public void addResearchPaper(ResearchPaper paper) {
        this.researchPapers.add(paper);
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return this.researchPapers;
    }

    @Override
    public int getHIndex() {
        return this.researchPapers.size(); 
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(this.researchPapers, comparator);
        System.out.println("--- Научные статьи студента " + getFirstName() + " ---");
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.toString());
        }
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    public Map<Course, Mark> getTranscript() {
        return transcript;
    }

    public void setTranscript(Map<Course, Mark> transcript) {
        this.transcript = transcript;
    }

    public void setResearchPapers(List<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + yearOfStudy;
        result = prime * result + credits;
        result = prime * result + failCount;
        result = prime * result + ((major == null) ? 0 : major.hashCode());
        result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
        result = prime * result + ((transcript == null) ? 0 : transcript.hashCode());
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
        Student other = (Student) obj;
        if (yearOfStudy != other.yearOfStudy)
            return false;
        if (credits != other.credits)
            return false;
        if (failCount != other.failCount)
            return false;
        if (major == null) {
            if (other.major != null)
                return false;
        } else if (!major.equals(other.major))
            return false;
        if (supervisor == null) {
            if (other.supervisor != null)
                return false;
        } else if (!supervisor.equals(other.supervisor))
            return false;
        if (transcript == null) {
            if (other.transcript != null)
                return false;
        } else if (!transcript.equals(other.transcript))
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
        return "Student [yearOfStudy=" + yearOfStudy + ", credits=" + credits + ", failCount=" + failCount + ", major="
                + major + ", supervisor=" + supervisor + ", transcript=" + transcript + ", researchPapers="
                + researchPapers + "]";
    }
}
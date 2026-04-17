import java.util.*;

public interface Researcher {
    
    int getHIndex();
    
    void printPapers(Comparator<ResearchPaper> comparator);
    
    List<ResearchPaper> getResearchPapers();
    
    void addResearchPaper(ResearchPaper paper);
}
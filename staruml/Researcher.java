
import java.io.*;
import java.util.*;

/**
 * 
 */
public interface Researcher {

    /**
     * 
     */
    public void getHIndex(): int;

    /**
     * 
     */
    public void printPapers(c: Comporator<ResearchPaper>): void;

}

import Researcher;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Student extends User implements Researcher {

    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * 
     */
    private int yearOfStudy;

    /**
     * 
     */
    private int credits;

    /**
     * 
     */
    private int failCount;

    /**
     * 
     */
    private String major;

    /**
     * 
     */
    private Researcher supervisor;

    /**
     * 
     */
    private void transcript: Map<Course, Mark>;

    /**
     * 
     */
    public void registerForCourse(c: Course): void;

    /**
     * 
     */
    public void viewTranscript(): void;

    /**
     * 
     */
    public void rateTeacher(t: Teacher): void;



}
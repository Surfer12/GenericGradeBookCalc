package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Student class represents a student with a name, a list of grades, and an average score.
 *
 * @param <G> the type of grades, which should extend Number
 */
public class Student<G> {
    private final List<G> grades;
    private String name;
    private double average;
    /**
     * The number of assignments for the student.
     */
    private int assignmentCount;

    /**
     * Default constructor that initializes the student with an empty list of grades.
     */
    public Student() {
        this.grades = new ArrayList<>();
    }

    /**
     * Constructor that initializes the student with a name.
     *
     * @param name the name of the student
     */
    public Student(String name) {
        this();
        this.name = name;
    }

    /**
     * Constructor that initializes the student with a name and a list of grades.
     *
     * @param name   the name of the student
     * @param grades the list of grades
     */
    public Student(String name, List<G> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
    }

    /**
     * Gets the name of the student.
     *
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name the new name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a grade to the student's list of grades.
     *
     * @param grade the grade to add
     */
    public void addGrade(G grade) {
        grades.add(grade);
    }

    /**
     * Gets the list of grades.
     *
     * @return a new list containing the grades
     */
    public List<G> getGrades() {
        return new ArrayList<>(grades);
    }

    /**
     * Gets the average score of the student.
     *
     * @return the average score
     */
    public double getAverage() {
        return average;
    }

    /**
     * Sets the average score of the student.
     *
     * @param average the new average score
     */
    public void setAverage(double average) {
        this.average = average;
    }

    /**
     * Gets the grades as a string.
     *
     * @return a string representation of the grades
     */
    public String getGradesAsString() {
        return grades.toString();
    }

    public void updateGrade(int assignmentNumber, G newGrade) {
        if (assignmentNumber > 0 && assignmentNumber <= grades.size()) {
            grades.set(assignmentNumber - 1, newGrade);
        } else {
            System.out.println("Invalid assignment number.");
        }
    }

    /**
     * Gets the number of assignments (grades).
     *
     * @return the number of grades
     */
    public int getNumAssignments() {
        return grades.size();
    }

    /**
     * Gets the number of assignments for the student.
     *
     * @return the number of assignments
     */
    public int getAssignmentCount() {
        return assignmentCount;
    }

    /**
     * Sets the number of assignments for the student.
     *
     * @param assignmentCount the number of assignments
     */
    public void setAssignmentCount(int assignmentCount) {
        this.assignmentCount = assignmentCount;
    }

    /**
     * Gets the total score of all grades.
     *
     * @return the total score, or 0 if grades are empty or not numbers
     */
    public int getTotalScore() {
        if (grades.isEmpty() || !(grades.get(0) instanceof Number)) {
            return 0;
        }
        return grades.stream()
                .mapToInt(g -> ((Number) g).intValue())
                .sum();
    }
}

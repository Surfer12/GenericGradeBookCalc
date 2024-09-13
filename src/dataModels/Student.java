package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student<G extends Number> {
    private final List<G> grades;
    private String name;
    private double average;
    private int assignmentCount;

    // Default constructor initializes grades
    public Student() {
        this.grades = new ArrayList<>();
    }

    // Constructor with name
    public Student(String name) {
        this();
        this.name = name;
    }

    // Constructor with name and grades
    public Student(String name, List<G> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades); // Initialize final field
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(G grade) {
        grades.add(grade);
        updateAverage();
    }

    public List<G> getGrades() {
        return new ArrayList<>(grades);
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getGradesAsString() {
        return grades.toString();
    }

    public Optional<Student<G>> updateGrade(String name, int assignmentNumber, G grade) {
        Optional<?> result = StudentRegistry.getInstance().updateGrade(name, assignmentNumber, grade);
        return result.filter(Student.class::isInstance)
                .map(Student.class::cast);
    }

    public int getNumAssignments() {
        return grades.size();
    }

    public int getAssignmentCount() {
        return assignmentCount;
    }

    public void setAssignmentCount(int assignmentCount) {
        this.assignmentCount = assignmentCount;
    }

    public int getTotalScore() {
        return grades.stream()
                .mapToInt(G::intValue)
                .sum();
    }

    private void updateAverage() {
        if (grades.isEmpty()) {
            average = 0.0;
        } else {
            double sum = grades.stream()
                    .mapToDouble(Number::doubleValue)
                    .sum();
            average = sum / grades.size();
        }
    }
}

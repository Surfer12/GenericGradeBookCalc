package dataModels;

import java.util.ArrayList;
import java.util.List;

public class Student<G extends Number> {
    private final List<G> grades;
    private String name;
    private double average;
    private int assignmentCount;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public Student(String name, List<G> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(G grade) {
        grades.add(grade);
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

    public void updateGrade(int assignmentNumber, G newGrade) {
        if (assignmentNumber > 0 && assignmentNumber <= grades.size()) {
            grades.set(assignmentNumber - 1, newGrade);
        } else if (assignmentNumber == grades.size() + 1) {
            grades.add(newGrade);
        } else {
            System.out.println("Invalid assignment number.");
        }
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
}

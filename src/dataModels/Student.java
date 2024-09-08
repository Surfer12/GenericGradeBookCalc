package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Student<G>> updateGrade(String name, int assignmentNumber, G grade) {
        return getCurrentStudentRegistry().getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(student -> {
                    student.addGrade(grade);
                    System.out.println("Grade updated for student: " + name);
                    return student;
                });
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

    // Add this method to your Student class
    private StudentRegistry<Student<G>, G> getCurrentStudentRegistry() {
        // Implement the logic to return the current StudentRegistry instance
        return StudentRegistry.getInstance(); // Example, replace with actual implementation
    }
}

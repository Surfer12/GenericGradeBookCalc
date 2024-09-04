import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student<G> {
    private final List<G> grades;
    private String name;
    private double average;

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

    public int getNumAssignments() {
        return grades.size();
    }

    public int getTotalScore() {
        if (grades.isEmpty() || !(grades.get(0) instanceof Number)) {
            return 0;
        }
        return grades.stream()
                .mapToInt(g -> ((Number) g).intValue())
                .sum();
    }
}
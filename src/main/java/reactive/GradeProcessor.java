package reactive;

import dataModels.Student;
import java.util.List;

public class GradeProcessor {

    private final GradeStrategy gradeStrategy;

    public GradeProcessor(GradeStrategy gradeStrategy) {
        this.gradeStrategy = gradeStrategy;
    }

    public double calculateAverage(Student student) {
        List<Integer> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = grades.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
        return sum / grades.size();
    }

    public static void main(String[] args) {
        GradeStrategy strategy = new LetterGradeStrategy();

        GradeProcessor gradeProcessor = new GradeProcessor(strategy);

        Student student = new Student("Test Student", Arrays.asList(95, 82, 67, 54, 88));

        double average = gradeProcessor.calculateAverage(student);
        System.out.println("Average Grade: " + average);
    }
}
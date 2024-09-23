package reactive;

import dataModels.Student;
import reactive.PassFailStrategy;
import java.util.Arrays;
import java.util.List;

public class GradeProcessor {

    private final GradeStrategy gradeStrategy;

    public GradeProcessor(GradeStrategy gradeStrategy, GradeStrategy passFailStrategy) {
        this.gradeStrategy = gradeStrategy;
    }

    public static void main(String[] args) {
        GradeStrategy strategy = new LetterGradeStrategy();

        GradeProcessor gradeProcessor = new GradeProcessor(strategy, PassFailStrategy.getInstance());

        Student<Integer> student = new Student<>("Test Student", Arrays.asList(95, 82, 67, 54, 88));

        double average = gradeProcessor.calculateAverage(student);
        System.out.println("Average Grade: " + average);
    }

    public double calculateAverage(Student<Integer> student) {
        List<Integer> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = grades.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
        return sum / grades.size();
    }
}
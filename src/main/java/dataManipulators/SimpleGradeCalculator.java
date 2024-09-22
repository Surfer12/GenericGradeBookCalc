package main.java.dataManipulators;

import java.util.List;

import main.java.dataModels.Student;

/**
 * The dataManipulators.SimpleGradeCalculator class implements the dataManipulators.GradeCalculator interface for dataModels.Student objects.
 * It calculates the average score of a student based on their total score and number of assignments.
 *
 * @param <S> the type of dataModels.Student
 */
public class SimpleGradeCalculator<S extends Student<G>, G extends Number> implements GradeCalculator<S, G> {

    /**
     * Calculates the average score of a student.
     *
     * @param student the student whose average score is to be calculated
     * @return the average score of the student, or 0 if the student has no assignments
     */
    @Override
    public double calculateAverage(S student) {
        List<G> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = grades.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
        return sum / grades.size();
    }
}
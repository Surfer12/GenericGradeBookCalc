package dataManipulators;

import java.util.List;

import dataModels.Student;

/**
 * An interface for calculating the average grade of a student.
 *
 * @param <S> the type of student, which extends the dataModels.Student class
 */
@FunctionalInterface
public interface GradeCalculator<S extends Student<G>, G extends Number> {

    // Usage with lambda
    GradeCalculator<Student<Integer>, Integer> calculator = student -> {
        List<Integer> grades = student.getGrades();
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    };

    /**
     * Calculates the average grade for the given student.
     *
     * @param student the student whose average grade is to be calculated
     * @return the calculated average grade as a double
     */
    double calculateAverage(S student);
}

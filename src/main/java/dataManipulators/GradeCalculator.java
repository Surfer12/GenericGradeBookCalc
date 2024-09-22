package dataManipulators;

import dataModels.Student;

/**
 * An interface for calculating the average grade of a student.
 *
 * @param <S> the type of student, which extends the dataModels.Student class
 */
@FunctionalInterface
public interface GradeCalculator<S extends Student<G>, G extends Number> {

    /**
     * Calculates the average grade for the given student.
     *
     * @param student the student whose average grade is to be calculated
     * @return the calculated average grade as a double
     */
    double calculateAverage(S student);
}

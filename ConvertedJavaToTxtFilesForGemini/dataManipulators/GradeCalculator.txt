package dataManipulators;
import dataModels.Student;

/**
 * An interface for calculating the average grade of a student.
 *
 * @param <S> the type of student, which extends the dataModels.Student class
 */
public interface GradeCalculator<S extends Student<?>> {

    /**
     * Calculates the average grade for the given student.
     *
     * @param student the student whose average grade is to be calculated
     * @return the calculated average grade as a double
     */
    double calculateAverage(S student);
}
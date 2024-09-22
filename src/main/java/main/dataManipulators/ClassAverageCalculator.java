package dataManipulators;

import dataModels.Student;

import java.util.List;

/**
 * Interface for calculating the class average.
 *
 * @param <S> the type of student that the calculator works with
 */
public interface ClassAverageCalculator<S extends Student<?>> {

    /**
     * Calculates the average score of a list of students.
     *
     * @param students the list of students
     * @return the average score of the students
     */
    double calculateAverage(List<S> students);
}

package dataManipulators;

import dataModels.Student;

/**
 * The dataManipulators.SimpleGradeCalculator class implements the dataManipulators.GradeCalculator interface for dataModels.Student objects.
 * It calculates the average score of a student based on their total score and number of assignments.
 *
 * @param <S> the type of dataModels.Student
 */
public class SimpleGradeCalculator<S extends Student<?>> implements GradeCalculator<S> {

    /**
     * Calculates the average score of a student.
     *
     * @param student the student whose average score is to be calculated
     * @return the average score of the student, or 0 if the student has no assignments
     */
    @Override
    public double calculateAverage(S student) {
        if (student.getNumAssignments() == 0) {
            return 0;
        }
        return (double) student.getTotalScore() / student.getNumAssignments();
    }
}
package src.main.handlers;

import dataModels.Student;

import javax.inject.Singleton;

/**
 * Represents a console-based grade entry system.
 *
 * @param <S> the type of student in the grade entry system
 * @param <G> the type of grade to be entered
 */
@Singleton
public class ConsoleGradeEntrySystem<S extends Student<G>, G extends Number> implements GradeEntrySystem<S, G> {
    private final InputHandler<G> gradeInputHandler;

    /**
     * Constructs a ConsoleGradeEntrySystem with the specified InputHandler.
     *
     * @param gradeInputHandler the input handler for entering grades
     */
    public ConsoleGradeEntrySystem(InputHandler<G> gradeInputHandler) {
        this.gradeInputHandler = gradeInputHandler;
    }

    /**
     * Prompts the user to enter a grade for a specific assignment for the given student.
     *
     * @param student          the student for whom the grade is being entered
     * @param assignmentNumber the assignment number for which the grade is being entered
     * @return the grade entered by the user
     */
    @Override
    public G enterGradeForAssignment(S student, int assignmentNumber) {
        return gradeInputHandler.getInput("Enter grade for " + student.getName() + " for assignment " + assignmentNumber + ": ");
    }
}
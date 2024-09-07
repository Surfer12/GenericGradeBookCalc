package handlers;

import dataModels.Student;

/**
 * Represents a console-based grade entry system.
 * This class implements the handlers.GradeEntrySystem interface and provides methods for entering grades for assignments.
 *
 * @param <S> the type of student in the grade entry system
 * @param <G> the type of grade to be entered
 */
public class ConsoleGradeEntrySystem<S extends Student<G>, G extends Number> implements GradeEntrySystem<S, G> {
    private final InputHandler<G> scoreInputHandler;

    /**
     * Constructs a handlers.ConsoleGradeEntrySystem with the specified handlers.InputHandler.
     *
     * @param scoreInputHandler the input handler for entering grades
     */
    public ConsoleGradeEntrySystem(InputHandler<G> scoreInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
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
        return scoreInputHandler.getInput("Enter grade for assignment " + assignmentNumber + ": ");
    }
}
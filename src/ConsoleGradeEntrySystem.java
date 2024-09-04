/**
 * Represents a console-based grade entry system.
 * This class implements the GradeEntrySystem interface and provides methods for entering grades for assignments.
 *
 * @param <S> the type of student in the grade entry system
 * @param <G> the type of grade in the grade entry system
 */
public class ConsoleGradeEntrySystem<S extends Student<Integer>, G> implements GradeEntrySystem<S, Integer> {
    private final InputHandler<Integer> scoreInputHandler;

    /**
     * Constructs a ConsoleGradeEntrySystem with the specified InputHandler.
     *
     * @param scoreInputHandler the input handler for entering grades
     */
    public ConsoleGradeEntrySystem(InputHandler<Integer> scoreInputHandler) {
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
    public Integer enterGradeForAssignment(S student, int assignmentNumber) {
        return scoreInputHandler.getInput("Enter grade for assignment " + assignmentNumber + ": ");
    }
}
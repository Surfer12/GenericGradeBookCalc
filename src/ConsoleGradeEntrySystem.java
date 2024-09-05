/**
 * Represents a console-based grade entry system.
 * This class implements the GradeEntrySystem interface and provides methods for entering grades for assignments.
 *
 * @param <S> the type of student in the grade entry system
 */
public class ConsoleGradeEntrySystem<S extends Student<Integer>> implements GradeEntrySystem<S, Integer> {
    private final InputHandler<Integer> scoreInputHandler;
    private final InputHandler<Double> scoreDoubleInputHandler;

    /**
     * Constructs a ConsoleGradeEntrySystem with the specified InputHandler.
     *
     * @param scoreInputHandler the input handler for entering grades
     */
    public ConsoleGradeEntrySystem(InputHandler<Integer> scoreInputHandler, InputHandler<Double> scoreDoubleInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
        this.scoreDoubleInputHandler = scoreDoubleInputHandler;
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

    /**
     * Enters a grade for a specific assignment for the given student.
     *
     * @param student          the student for whom the grade is to be entered
     * @param assignmentNumber the number of the assignment for which the grade is to be entered
     * @return the entered grade of type G
     */
    public Double enterDoubleGradeForAssignment(Integer student, int assignmentNumber) {
        return scoreDoubleInputHandler.getInput("Enter grade for assignment " + assignmentNumber + ": ");
    }
}
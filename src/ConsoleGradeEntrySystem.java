
public class ConsoleGradeEntrySystem<S extends Student<Integer>, G> implements GradeEntrySystem<S, Integer> {
    private final InputHandler<Integer> scoreInputHandler;

    public ConsoleGradeEntrySystem(InputHandler<Integer> scoreInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
    }

    @Override
    public Integer enterGradeForAssignment(S student, int assignmentNumber) {
        return scoreInputHandler.getInput("Enter grade for assignment " + assignmentNumber + ": ");
    }
}
import java.util.List;

public class ConsoleGradeEntrySystem<S extends Student<G>, G> implements GradeEntrySystem<S, G> {
    private final InputHandler<G> scoreInputHandler;

    public ConsoleGradeEntrySystem(InputHandler<G> scoreInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
    }

    @Override
    public void enterGradesForStudent(S student) {
        System.out.println("Entering grades for " + student.getName() + ":");
        List<G> grades = scoreInputHandler.getMultipleInputs(
                "Enter grade (or type 'STOP' to finish): ",
                "STOP");

        for (G grade : grades) {
            student.addGrade(grade);
        }
    }
}
public class ConsoleGradeEntrySystem<S extends Student> implements GradeEntrySystem<S, Integer> {
    private final InputHandler<Integer> scoreInputHandler;

    public ConsoleGradeEntrySystem(InputHandler<Integer> scoreInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
    }

    @Override
    public void enterGradesForStudent(S student) {
        System.out.println("Entering grades for " + student.getName() + ":");
        List<Integer> grades = scoreInputHandler.getMultipleInputs(
                "Enter grade (or type 'STOP' to finish): ",
                "STOP"
        );

        for (Integer grade : grades) {
            student.addGrade(grade);
        }
    }
}
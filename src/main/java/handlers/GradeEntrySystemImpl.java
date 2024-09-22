package src.main.handlers;

import src.main.dataModels.Student;

public class GradeEntrySystemImpl<S extends Student<G>, G extends Number> implements GradeEntrySystem<S, G> {
    private final InputHandler<G> gradeInputHandler;

    public GradeEntrySystemImpl(InputHandler<G> gradeInputHandler) {
        this.gradeInputHandler = gradeInputHandler;
    }

    @Override
    public G enterGradeForAssignment(S student, int assignmentNumber) {
        return gradeInputHandler.getInput("Enter grade for " + student.getName() + " for assignment " + assignmentNumber + ": ");
    }
}
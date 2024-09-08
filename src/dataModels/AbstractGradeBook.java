package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class AbstractGradeBook<S extends Student<G>, G> {
    private StudentRegistry<S, G> studentRegistry;
    private InputHandler<String> nameInputHandler;
    private InputHandler<Integer> countInputHandler;
    private InputHandler<Integer> assignmentCountInputHandler;
    private GradeEntrySystem<S, G> gradeEntrySystem;
    private GradeCalculator<S> gradeCalculator;
    private GradebookDisplay<S> gradebookDisplay;
    private ClassAverageCalculator<S> classAverageCalculator;
    private Supplier<S> studentFactory;

    public AbstractGradeBook(StudentRegistry<S, G> studentRegistry,
                             InputHandler<String> nameInputHandler,
                             InputHandler<Integer> countInputHandler,
                             InputHandler<Integer> assignmentCountInputHandler,
                             GradeEntrySystem<S, G> gradeEntrySystem,
                             GradeCalculator<S> gradeCalculator,
                             GradebookDisplay<S> gradebookDisplay,
                             ClassAverageCalculator<S> classAverageCalculator,
                             Supplier<S> studentFactory) {
        this.studentRegistry = studentRegistry;
        this.nameInputHandler = nameInputHandler;
        this.countInputHandler = countInputHandler;
        this.assignmentCountInputHandler = assignmentCountInputHandler;
        this.gradeEntrySystem = gradeEntrySystem;
        this.gradeCalculator = gradeCalculator;
        this.gradebookDisplay = gradebookDisplay;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
    }

    public abstract void run();

    public abstract List<S> addStudents();

    public abstract void removeStudent();

    public abstract Optional<S> promptUpdateGrade();

    protected int getStudentCount() {
        // Implement the logic to get the student count
        return 0;
    }

    protected List<S> registerStudents(int studentCount) {
        // Implement the logic to register students
        return Collections.emptyList();
    }

    protected void enterGrades(List<S> students) {
        // Implement the logic to enter grades
    }

    protected void calculateGrades(List<S> students) {
        // Implement the logic to calculate grades
    }

    protected void displayResults(List<S> students) {
        // Implement the logic to display results
    }

    protected int getNewStudentCount() {
        // Implement the logic to get the count of new students
        return 0;
    }
}
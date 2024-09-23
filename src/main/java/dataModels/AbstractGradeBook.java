package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public abstract class AbstractGradeBook<S extends Student<G>, G extends Number> {

    protected final StudentRegistry<S, G> studentRegistry;
    protected final InputHandler<String> nameInputHandler;
    protected final InputHandler<Integer> countInputHandler;
    protected final InputHandler<Integer> assignmentCountInputHandler;
    protected final GradeEntrySystem<S, G> gradeEntrySystem;
    protected final GradeCalculator<S, G> gradeCalculator;
    protected final GradebookDisplay<S> gradebookDisplay;
    protected final ClassAverageCalculator<S> classAverageCalculator;
    protected final Supplier<S> studentFactory;
    protected final Set<String> uniqueNames;

    public AbstractGradeBook(StudentRegistry<S, G> studentRegistry,
                             InputHandler<String> nameInputHandler,
                             InputHandler<Integer> countInputHandler,
                             InputHandler<Integer> assignmentCountInputHandler,
                             GradeEntrySystem<S, G> gradeEntrySystem,
                             GradeCalculator<S, G> gradeCalculator,
                             GradebookDisplay<S> gradebookDisplay,
                             ClassAverageCalculator<S> classAverageCalculator,
                             Supplier<S> studentFactory,
                             Set<String> uniqueNames) {
        this.studentRegistry = studentRegistry;
        this.nameInputHandler = nameInputHandler;
        this.countInputHandler = countInputHandler;
        this.assignmentCountInputHandler = assignmentCountInputHandler;
        this.gradeEntrySystem = gradeEntrySystem;
        this.gradeCalculator = gradeCalculator;
        this.gradebookDisplay = gradebookDisplay;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
        this.uniqueNames = uniqueNames;
    }

    public abstract void run();

    public abstract List<S> addStudents();

    public abstract void removeStudent();

    public abstract Optional<S> promptUpdateGrade();

    protected int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: ");
    }

    protected List<S> registerStudents(int studentCount) {
        List<S> students = new ArrayList<>();
        for (int i = 1; i <= studentCount; i++) {
            S student = registerStudent();
            students.add(student);
        }
        return students;
    }

    protected S registerStudent() {
        String name = nameInputHandler
                .getInput("Enter the name of student " + (studentRegistry.countStudents() + 1) + ": ");
        int assignmentCount = assignmentCountInputHandler.getInput("Enter the number of grades for " + name + ": ");
        S student = studentFactory.get();
        student.setName(name);
        student.setAssignmentCount(assignmentCount);
        studentRegistry.addStudent(student);
        return student;
    }

    protected void enterGrades(List<S> students) {
        for (S student : students) {
            for (int i = 0; i < student.getAssignmentCount(); i++) {
                G grade = gradeEntrySystem.enterGradeForAssignment(student, i + 1);
                student.addGrade(grade);
            }
        }
    }

    protected void calculateGrades(List<S> students) {
        for (S student : students) {
            student.setAverage(gradeCalculator.calculateAverage(student));
        }
    }

    protected int getNewStudentCount() {
        return countInputHandler.getInput("Enter the number of new students: ");
    }

    protected void displayResults(List<S> students) {
        gradebookDisplay.display(students);
        System.out.println("Class Average: " + classAverageCalculator.calculateAverage(students));
    }
}

import java.util.List;
import java.util.function.Supplier;

public class GradeBook<S extends Student<Integer>> {
    private final StudentRegistry<S> studentRegistry;
    private final InputHandler<String> nameInputHandler;
    private final InputHandler<Integer> countInputHandler;
    private final GradeEntrySystem<S, Integer> gradeEntrySystem;
    private final GradeCalculator<S> gradeCalculator;
    private final ClassAverageCalculator<S> classAverageCalculator;
    private final Supplier<S> studentFactory;

    public GradeBook(
            StudentRegistry<S> studentRegistry,
            InputHandler<String> nameInputHandler,
            InputHandler<Integer> countInputHandler,
            GradeEntrySystem<S, Integer> gradeEntrySystem,
            GradeCalculator<S> gradeCalculator,
            GradebookDisplay<S> gradebookDisplay,
            ClassAverageCalculator<S> classAverageCalculator,
            Supplier<S> studentFactory) {
        this.studentRegistry = studentRegistry;
        this.nameInputHandler = nameInputHandler;
        this.countInputHandler = countInputHandler;
        this.gradeEntrySystem = gradeEntrySystem;
        this.gradeCalculator = gradeCalculator;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
    }

    public void run() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        promptForAssignmentCount(students);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    private int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: ");
    }

    private List<S> registerStudents(int count) {
        for (int i = 0; i < count; i++) {
            String name = nameInputHandler.getInput("Enter the name of student " + (i + 1) + ": ");
            S student = studentFactory.get();
            student.setName(name);
            studentRegistry.addStudent(student);
        }
        return studentRegistry.getAllStudents();
    }

// src/GradeBook.java
private void promptForAssignmentCount(List<S> students) {
    for (S student : students) {
        int assignmentCount = countInputHandler.getInput("Enter the number of assignments for " + student.getName() + ": ");
        student.setAssignmentCount(assignmentCount);
    }
}

private void enterGrades(List<S> students) {
    for (S student : students) {
        List<Integer> grades =
                countInputHandler.getMultipleInputs("Enter grade for " + student.getName() + " " + "assignment" + student.getNumAssignments() +
                        "(or" +
                        " " +
                "type " +
                "'stop' to finish): ", "stop");
        student.setGrades(grades);
    }
}

    private void calculateGrades(List<S> students) {
        for (S student : students) {
            double average = gradeCalculator.calculateAverage(student);
            student.setAverage(average);
        }
    }

    private void displayResults(List<S> students) {
        new ConsoleGradebookDisplay<S>().display(students);
        double classAverage = classAverageCalculator.calculateAverage(students);
        System.out.printf("Class Average: %.2f%n", classAverage);
    }
}
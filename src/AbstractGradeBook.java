import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class AbstractGradeBook<S extends Student<G>, G> {
    protected final StudentRegistry<S, G> studentRegistry;
    protected final InputHandler<String> nameInputHandler;
    protected final InputHandler<Integer> countInputHandler;
    protected final GradeEntrySystem<S, G> gradeEntrySystem;
    protected final GradeCalculator<S> gradeCalculator;
    protected final GradebookDisplay<S> gradebookDisplay;
    protected final ClassAverageCalculator<S> classAverageCalculator;
    protected final Supplier<S> studentFactory;

    public AbstractGradeBook(StudentRegistry<S, G> studentRegistry,
                             InputHandler<String> nameInputHandler,
                             InputHandler<Integer> countInputHandler,
                             GradeEntrySystem<S, G> gradeEntrySystem,
                             GradeCalculator<S> gradeCalculator,
                             GradebookDisplay<S> gradebookDisplay,
                             ClassAverageCalculator<S> classAverageCalculator,
                             Supplier<S> studentFactory) {
        this.studentRegistry = studentRegistry;
        this.nameInputHandler = nameInputHandler;
        this.countInputHandler = countInputHandler;
        this.gradeEntrySystem = gradeEntrySystem;
        this.gradeCalculator = gradeCalculator;
        this.gradebookDisplay = gradebookDisplay;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
    }

    public abstract void run();

    public abstract void addStudents();

    public abstract void removeStudent();

    public abstract Optional<S> promptUpdateGrade();

    protected int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: (or type 'unknown'): ");
    }

    protected int getAssignmentCount() {
        return countInputHandler.getInput("Enter the number of assignments: ");
    }

    protected List<S> registerStudents(int count) {
        for (int i = 0; i < count; i++) {
            String name = nameInputHandler.getInput("Enter the name of student " + (i + 1) + ": ");
            int assignmentCount = countInputHandler.getInput("Enter the number of assignments for " + name + ": ");
            S student = studentFactory.get();
            student.setName(name);
            student.setAssignmentCount(assignmentCount);
            studentRegistry.addStudent(student);
        }
        return studentRegistry.getAllStudents();
    }

    protected void enterGrades(List<S> students) {
        for (S student : students) {
            System.out.println("Entering grades for " + student.getName() + ":");
            for (int i = 0; i < student.getAssignmentCount(); i++) {
                G grade = gradeEntrySystem.enterGradeForAssignment(student, i + 1);
                student.addGrade(grade);
            }
        }
    }

    protected void calculateGrades(List<S> students) {
        for (S student : students) {
            double average = gradeCalculator.calculateAverage(student);
            student.setAverage(average);
        }
    }

    protected void displayResults(List<S> students) {
        gradebookDisplay.display(students);
        System.out.printf("Class Average: %.2f%n", classAverageCalculator.calculateAverage(students));
    }
}
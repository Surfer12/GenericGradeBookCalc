import java.util.List;
import java.util.function.Supplier;

/**
 * \*\*Class\*\*
 * GradeBook
 * <p>
 * \*\*Description\*\*
 * This class manages the grade book for a list of students, including registering students, entering grades, calculating averages, and displaying results.
 * <p>
 * \*\*Type Parameters\*\*
 * \- \`<S>\` \- the type of student, which must extend the Student class.
 */
public class GradeBook<S extends Student<Integer>> {
    private final StudentRegistry<S> studentRegistry;
    private final InputHandler<String> nameInputHandler;
    private final InputHandler<Integer> countInputHandler;
    private final GradeEntrySystem<S, Integer> gradeEntrySystem;
    private final GradeCalculator<S> gradeCalculator;
    private final GradebookDisplay<S> gradebookDisplay;
    private final ClassAverageCalculator<S> classAverageCalculator;
    private final Supplier<S> studentFactory;

    /**
     * Constructs a GradeBook with the specified components.
     * <p>
     * \*\*Parameters\*\*
     * \- \`studentRegistry\` \- the registry to manage student information.
     * \- \`nameInputHandler\` \- the input handler for student names.
     * \- \`countInputHandler\` \- the input handler for counts (students and assignments).
     * \- \`gradeEntrySystem\` \- the system to enter grades.
     * \- \`gradeCalculator\` \- the calculator to compute student averages.
     * \- \`gradebookDisplay\` \- the display system for showing results.
     * \- \`classAverageCalculator\` \- the calculator to compute the class average.
     * \- \`studentFactory\` \- the factory to create new student instances.
     */
    public GradeBook(StudentRegistry<S> studentRegistry,
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
        this.gradebookDisplay = gradebookDisplay;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
    }

    /**
     * Runs the grade book process, including registering students, entering grades, calculating averages, and displaying results.
     */
    public void run() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    /**
     * Prompts for and returns the number of students.
     * <p>
     * \*\*Returns\*\*
     * \- the number of students as an integer.
     */
    private int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: ");
    }

    /**
     * Prompts for and returns the number of assignments.
     * <p>
     * \*\*Returns\*\*
     * \- the number of assignments as an integer.
     */
    private int getAssignmentCount() {
        return countInputHandler.getInput("Enter the number of assignments: ");
    }

 /**
 * Registers the specified number of students by prompting for their names and the number of assignments.
 *
 * @param count the number of students to register
 * @return a list of registered students
 */
private List<S> registerStudents(int count) {
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

/**
 * Enters grades for each student for the number of assignments stored in each student.
 *
 * @param students the list of students
 */
private void enterGrades(List<S> students) {
    for (S student : students) {
        System.out.println("Entering grades for " + student.getName() + ":");
        for (int i = 0; i < student.getAssignmentCount(); i++) {
            int grade = gradeEntrySystem.enterGradeForAssignment(student, i + 1);
            student.addGrade(grade);
        }
    }
}
    /**
     * Calculates the average grade for each student.
     * <p>
     * \*\*Parameters\*\*
     * \- \`students\` \- the list of students.
     */
    private void calculateGrades(List<S> students) {
        for (S student : students) {
            double average = gradeCalculator.calculateAverage(student);
            student.setAverage(average);
        }
    }

    /**
     * Displays the results for each student and the class average.
     * <p>
     * \*\*Parameters\*\*
     * \- \`students\` \- the list of students.
     */
    private void displayResults(List<S> students) {
        gradebookDisplay.display(students);
        System.out.printf("Class Average: %.2f%n", classAverageCalculator.calculateAverage(students));
    }
}
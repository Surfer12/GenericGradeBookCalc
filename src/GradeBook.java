import java.util.List;
import java.util.Optional;
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

    //Prompt after gradebook is run to request if any additional students need to be added
    public void addStudents() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    // Create a method to remove a student from the gradebook
    public void removeStudent() {
        //Prompt user to enter the name of the student to remove
        String name = nameInputHandler.getInput("Enter the name of the student to remove: ");
        //Remove the student from the student registry
        studentRegistry.removeStudent(name);
        //Get the list of students
        List<S> students = studentRegistry.getAllStudents();
        //Display the results
        displayResults(students);
    }
/**
 * Prompts the user to update a student's grade.
 *
 * @return an Optional containing the updated student if found, otherwise an empty Optional
 */
public Optional<S> promptUpdateGrade() {
    // Prompt user to enter the name of the student to update
    String name = nameInputHandler.getInput("Enter the name of the student to update: ");
    // Get the student from the student registry
    Optional<S> student = studentRegistry.getStudent(name);
    // Prompt user to enter the assignment number to update
    int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: ");
    // Prompt user to enter the new grade
    int grade = countInputHandler.getInput("Enter the new grade: ");
    // Update the grade
    student.ifPresent(s -> s.updateGrade(assignmentNumber, grade));
    // Get the list of students
    List<S> students = studentRegistry.getAllStudents();
    // Display the results
    displayResults(students);
    // Return the updated student
    return student;
}
    /**
     **Returning the Optional<S> value at the end of the promptUpdateGrade method can be useful
     for several reasons:
Chaining Operations: Returning the Optional<S> allows for further operations to be chained on the result. This can be useful if additional processing or checks are needed on the updated student.
Error Handling: By returning an Optional, the method clearly indicates whether the student was found and updated. This can be useful for error handling and logging purposes.
Consistency: If other methods in the class return Optional values, it maintains consistency in the API design.*/


    /**
     * Prompts for and returns the number of students.
     * <p>
     * \*\*Returns\*\*
     * \- the number of students as an integer.
     */
    // Accepts 'unknown' string as a command during addition of students to create an arraylist
    // of standard size to store the students that are then added to the student registry
    private int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: (or type 'unknown'): ");
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
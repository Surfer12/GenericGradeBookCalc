import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


public class GradeBook<S extends Student<G>, G> extends AbstractGradeBook<S, G> {
    public GradeBook(StudentRegistry<S, G> studentRegistry,
                     InputHandler<String> nameInputHandler,
                     InputHandler<Integer> countInputHandler,
                     GradeEntrySystem<S, G> gradeEntrySystem,
                     GradeCalculator<S> gradeCalculator,
                     GradebookDisplay<S> gradebookDisplay,
                     ClassAverageCalculator<S> classAverageCalculator,
                     Supplier<S> studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler, gradeEntrySystem, gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }


    @Override
    public void run() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    @Override
    public void addStudents() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }
    @Override
    public void removeStudent() {
        String name = nameInputHandler.getInput("Enter the name of the student to remove: ");
        studentRegistry.removeStudent(name);
        List<S> students = studentRegistry.getAllStudents();
        displayResults(students);
    }
    @Override
    public Optional<S> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update: ");
        Optional<S> student = studentRegistry.getStudent(name);
        int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: ");
        G grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
        student.ifPresent(s -> s.updateIndividualGrade(name, assignmentNumber, (Number) grade));
        List<S> students = studentRegistry.getAllStudents();
        displayResults(students);
        return student;
    }
    }
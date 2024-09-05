import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class GradeBook<S extends Student<G>, G> extends AbstractGradeBook<S, G> {
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
        removeStudent();
        addStudents();
        promptUpdateGrade();
    }

    @Override
    public void addStudents() {
        int studentCount = getNewStudentCount();
        if (studentCount == 0) {
            System.out.println("No new students added.");
            return;
        }
        List<S> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    @Override
    public void removeStudent() {
        String name = nameInputHandler.getInput("Enter the name of the student to remove: " +
                "('STOP' to remove none.) ");
        if(name.equalsIgnoreCase("STOP")) {
            System.out.println("No students removed.");
            return;
        }
        studentRegistry.removeStudent(name);
        List<S> students = studentRegistry.getAllStudents();
        displayResults(students);
    }

    @Override
    public Optional<S> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update their " +
                "grade: "+
                "('STOP' to update none of the student's individual grades.) ");
        if(name.equalsIgnoreCase("STOP")) {
            System.out.println("No student grade(s) have been updated.");
            return Optional.empty();
        }
        Optional<S> student = studentRegistry.getStudent(name);
        if(student.isEmpty()) {
            System.out.println("Student not found.");
            return Optional.empty();
        }
        int assignmentNumber = countInputHandler.getInput("Enter the assignment number to " +
                "update: " +
                "('STOP' to update none of the individual assignments) ");
        if(name.equalsIgnoreCase("STOP")) {
            System.out.println("No individual student assignment has been updated.");
        } if (assignmentNumber == 0) {
            System.out.println("No individual student assignment has been updated.");
            return student;
        }
        G grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
        student.ifPresent(s -> s.updateGrade(name, assignmentNumber, (Number) grade));
        List<S> students = studentRegistry.getAllStudents();
        displayResults(students);
        return student;
    }
}
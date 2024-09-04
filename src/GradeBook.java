import java.util.List;
import java.util.function.Supplier;

public class GradeBook<S extends Student<Integer>> {
    private final StudentRegistry<S> studentRegistry;
    private final InputHandler<String> nameInputHandler;
    private final InputHandler<Integer> countInputHandler;
    private final GradeEntrySystem<S, Integer> gradeEntrySystem;
    private final GradeCalculator<S> gradeCalculator;
    private final GradebookDisplay<S> gradebookDisplay;
    private final ClassAverageCalculator<S> classAverageCalculator;
    private final Supplier<S> studentFactory;

    // Constructor remains the same
    // ...

    public void run() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        int assignmentCount = getAssignmentCount();
        enterGrades(students, assignmentCount);
        calculateGrades(students);
        displayResults(students);
    }

    private int getStudentCount() {
        return countInputHandler.getInput("Enter the number of students: ");
    }

    private int getAssignmentCount() {
        return countInputHandler.getInput("Enter the number of assignments: ");
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

    private void enterGrades(List<S> students, int assignmentCount) {
        for (S student : students) {
            System.out.println("Entering grades for " + student.getName() + ":");
            for (int i = 0; i < assignmentCount; i++) {
                int grade = gradeEntrySystem.enterGradeForAssignment(student, i + 1);
                student.addGrade(grade);
            }
        }
    }

    private void calculateGrades(List<S> students) {
        for (S student : students) {
            double average = gradeCalculator.calculateAverage(student);
            student.setAverage(average);
        }
    }

    private void displayResults(List<S> students) {
        gradebookDisplay.displayGradebook(students);
        double classAverage = classAverageCalculator.calculateClassAverage(students);
        System.out.printf("Class Average: %.2f%n", classAverage);
    }
}
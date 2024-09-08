package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler; // Fix import

import java.util.function.Supplier;
import java.util.List;
import java.util.Optional;

public class IntegerGradeBook extends AbstractGradeBook<Student<Integer>, Integer> {
    public IntegerGradeBook(StudentRegistry<Student<Integer>, Integer> studentRegistry,
                            InputHandler<String> nameInputHandler,
                            InputHandler<Integer> countInputHandler,
                            InputHandler<Integer> assignmentCountInputHandler,
                            GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem,
                            GradeCalculator< Student<Integer> > gradeCalculator,
                            GradebookDisplay< Student<Integer> > gradebookDisplay,
                            ClassAverageCalculator< Student<Integer> > classAverageCalculator,
                            Supplier< Student<Integer> > studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }

    @Override
    public void run() {
        int studentCount = getStudentCount();
        List<Student<Integer>> students = registerStudents(studentCount);
        enterGrades(students);
        calculateGrades(students);
        displayResults(students);
    }

    @Override
    public List<Student<Integer>> addStudents() {
        int newStudentCount = getNewStudentCount();
        return registerStudents(newStudentCount);
    }

    @Override
    public void removeStudent() {
        String name = nameInputHandler.getInput("Enter the name of the student to remove: ");
        studentRegistry.removeStudent(name);
        displayResults(studentRegistry.getAllStudents());
    }

    @Override
    public Optional<Student<Integer>> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update their grade: ");
        Optional<Student<Integer>> student = studentRegistry.getStudent(name);
        if (student.isPresent()) {
            int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: ");
            Integer grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
            student.get().updateGrade(assignmentNumber, grade);
            displayResults(studentRegistry.getAllStudents());
        } else {
            System.out.println("Student not found.");
        }
        return student;
    }

    private void displayResults(List<Student<Integer>> students) {
        gradebookDisplay.display(students);
    }
}
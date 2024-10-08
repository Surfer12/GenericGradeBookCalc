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


public class IntegerGradeBook extends AbstractGradeBook<Student<Integer>, Integer> {
    public IntegerGradeBook(StudentRegistry<Student<Integer>, Integer> studentRegistry,
                            InputHandler<String> nameInputHandler,
                            InputHandler<Integer> countInputHandler,
                            InputHandler<Integer> assignmentCountInputHandler,
                            GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem,
                            GradeCalculator<Student<Integer>, Integer> gradeCalculator,
                            GradebookDisplay<Student<Integer>> gradebookDisplay,
                            ClassAverageCalculator<Student<Integer>> classAverageCalculator,
                            Supplier<Student<Integer>> studentFactory,
                            Set<String> uniqueNames) { // Add the uniqueNames parameter
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory, uniqueNames); // Pass it to the superclass constructor
    }

    @Override
    public void run() {
        int studentCount = getStudentCount(); // Get the new student count
        List<Student<Integer>> students = registerStudents(studentCount); // register the students and return the list
        enterGrades(students); // enter the grades for each student
        calculateGrades(students); // Calculate grades for each student
        displayResults(students); // Display the results
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
        displayResults(new ArrayList<>(studentRegistry.getAllStudents().values()));
    }

    @Override
    public Optional<Student<Integer>> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update their grade: ");
        Optional<Student<Integer>> student = studentRegistry.getStudent(name);
        if (student.isPresent()) {
            int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: ");
            Integer grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
            student.get().updateGrade(name, assignmentNumber, grade);
            displayResults(new ArrayList<>(studentRegistry.getAllStudents().values()));
        } else {
            System.out.println("Student not found.");
        }
        return student;
    }

    @Override
    public void displayResults(List<Student<Integer>> students) {
        gradebookDisplay.display(new ArrayList<>(studentRegistry.getAllStudents().values()));
        System.out.println("Class Average: " + classAverageCalculator.calculateAverage(new ArrayList<>(studentRegistry.getAllStudents().values())));
    }
}

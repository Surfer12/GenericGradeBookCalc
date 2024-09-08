package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler; // Fix import

import java.util.function.Supplier;
import java.util.List;
import java.util.Optional;

public class DoubleGradeBook extends AbstractGradeBook<Student<Double>, Double> {
    public DoubleGradeBook(StudentRegistry<Student<Double>, Double> studentRegistry,
            InputHandler<String> nameInputHandler,
            InputHandler<Integer> countInputHandler,
            InputHandler<Integer> assignmentCountInputHandler,
            GradeEntrySystem<Student<Double>, Double> gradeEntrySystem,
            GradeCalculator<Student<Double>> gradeCalculator,
            GradebookDisplay<Student<Double>> gradebookDisplay,
            ClassAverageCalculator<Student<Double>> classAverageCalculator,
            Supplier<Student<Double>> studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }

    @Override
    public void run() {
    int studentCount = getStudentCount();
    List<Student<Double>> students = registerStudents(studentCount);
    enterGrades(students);
    calculateGrades(students);
    displayResults(students);
    }

    @Override
    public List<Student<Double>> addStudents() {
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
    public Optional<Student<Double>> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update their grade: ");
        Optional<Student<Double>> student = studentRegistry.getStudent(name);
        if (student.isPresent()) {
            int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: ");
            Double grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
            student.get().updateGrade(name, assignmentNumber, grade);
            displayResults(studentRegistry.getAllStudents());
        } else {
            System.out.println("Student not found.");
        }
        return student;
    }

    @Override
    public void displayResults(List<Student<Double>> students) {
        gradebookDisplay.display(students);
        System.out.println("Class Average: " + classAverageCalculator.calculateAverage(students));
    }

    public void addStudent(Student<Double> student) {
        // Logic to add student to the registry
    }

    public void updateGrade(Student<Double> student, double grade) {
        // Logic to update the student's grade
    }

    public void removeStudent(Student<Double> student) {
        // Logic to remove student from the registry
    }
}
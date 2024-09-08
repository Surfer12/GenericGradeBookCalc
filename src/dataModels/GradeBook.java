package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class GradeBook<S extends Student<G>, G> extends AbstractGradeBook<S, G> {
    public GradeBook(StudentRegistry<S, G> studentRegistry,
                     InputHandler<String> nameInputHandler,
                     InputHandler<Integer> countInputHandler,
                     InputHandler<Integer> assignmentCountInputHandler,
                     GradeEntrySystem<S, G> gradeEntrySystem,
                     GradeCalculator<S> gradeCalculator,
                     GradebookDisplay<S> gradebookDisplay,
                     ClassAverageCalculator<S> classAverageCalculator,
                     Supplier<S> studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }

    @Override
    public void run() {
        int studentCount = getStudentCount();
        List<S> students = registerStudents(studentCount);
        enterGrades(students); // Enter grades for initial students
        calculateGrades(students);
        displayResults(students);

        /* Using this project to learn about Java generics and how to use them effectively so
         these methods are commented out for now.*/

        /*removeStudent();
        promptUpdateGrade();
        /*addNewStudents();*/
    }

    @Override
    public List<S> addStudents() {
        int studentCount = getNewStudentCount();
        if (studentCount == 0) {
            System.out.println("No new students added.");
            return Collections.emptyList();
        }
        List<S> newStudents = registerStudents(studentCount);
        return newStudents;
    }

    public void addNewStudents() {
        List<S> newStudents = addStudents();
        if (!newStudents.isEmpty()) {
            enterGrades(newStudents); // Only enter grades for new students
            calculateGrades(newStudents);
            displayResults(newStudents);
        }
    }

    @Override
    public void removeStudent() {
        String name = nameInputHandler.getInput("Enter the name of the student to remove: " +
                "('STOP' to remove none.) ");
        if (name.equalsIgnoreCase("STOP")) {
            System.out.println("No students removed.");
            return;
        }
        studentRegistry.removeStudent(name);
        List<S> students = studentRegistry.getAllStudents();
        displayResults(students);
    }

    @Override
    public Optional<S> promptUpdateGrade() {
        String name = nameInputHandler.getInput("Enter the name of the student to update their grade: " +
                "('STOP' to update none of the student's individual grades.) ");
        if (name.equalsIgnoreCase("STOP")) {
            System.out.println("No student grade(s) have been updated.");
            return Optional.empty();
        }
        Optional<S> student = studentRegistry.getStudent(name);
        if (student.isEmpty()) {
            System.out.println("Student not found.");
            return Optional.empty();
        }
        int assignmentNumber = countInputHandler.getInput("Enter the assignment number to update: " +
                "('STOP' to update none of the individual assignments) ");
        if (name.equalsIgnoreCase("STOP")) {
            System.out.println("No individual student assignment has been updated.");
        } else if (assignmentNumber == 0) {
            System.out.println("No individual student assignment has been updated.");
            return student;
        } else {
            G grade = gradeEntrySystem.enterGradeForAssignment(student.get(), assignmentNumber);
            student.ifPresent(s -> s.updateGrade(assignmentNumber, grade));
            List<S> students = studentRegistry.getAllStudents();
            displayResults(students);
        }
        return student;
    }
}
package main;

import Displays.GradebookDisplayImpl;
import dataManipulators.ClassAverageCalculatorImpl;
import dataManipulators.GradeCalculator;
import dataModels.DoubleGradeBook;
import dataModels.IntegerGradeBook;
import dataModels.Student;
import dataModels.StudentRegistry;
import handlers.ConsoleInputHandler;
import handlers.GradeEntrySystemImpl;
import handlers.InputHandler;
import validators.InputValidator;
import validators.NameValidator;
import validators.PositiveIntegerValidator;
import validators.ScoreValidator;
import validators.DoubleValidator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Integer GradeBook setup
        InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
        InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

        InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
        InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

        InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
        InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

        StudentRegistry<Student<Integer>, Integer> integerStudentRegistry = StudentRegistry.getInstance();
        Supplier<Student<Integer>> integerStudentFactory = () -> {
            String name = nameInputHandler.getInput("Enter student name: ");
            return new Student<>(name);
        };

        IntegerGradeBook integerGradeBook = new IntegerGradeBook(
                integerStudentRegistry,
                nameInputHandler,
                countInputHandler,
                countInputHandler,
                new GradeEntrySystemImpl<>(scoreInputHandler),
                new GradeCalculator<>() {
                    @Override
                    public double calculateAverage(Student<Integer> student) {
                        List<Integer> grades = student.getGrades();
                        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                    }
                },
                new GradebookDisplayImpl<>(),
                new ClassAverageCalculatorImpl<>(),
                integerStudentFactory
        );

        // Double GradeBook setup
        InputValidator<Double> doubleValidator = new InputValidator<>(new DoubleValidator(), "double score");
        InputHandler<Double> doubleScoreInputHandler = new ConsoleInputHandler<>(scanner, doubleValidator);

        StudentRegistry<Student<Double>, Double> doubleStudentRegistry = StudentRegistry.getInstance();
        Supplier<Student<Double>> doubleStudentFactory = () -> {
            String name = nameInputHandler.getInput("Enter student name: ");
            return new Student<>(name);
        };

        DoubleGradeBook doubleGradeBook = new DoubleGradeBook(
                doubleStudentRegistry,
                nameInputHandler,
                countInputHandler,
                countInputHandler,
                new GradeEntrySystemImpl<>(doubleScoreInputHandler),
                new GradeCalculator<>() {
                    @Override
                    public double calculateAverage(Student<Double> student) {
                        List<Double> grades = student.getGrades();
                        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    }
                },
                new GradebookDisplayImpl<>(),
                new ClassAverageCalculatorImpl<>(),
                doubleStudentFactory
        );

        // Demonstrate IntegerGradeBook
        System.out.println("Running Integer GradeBook:");
        integerGradeBook.run();

        // Add a student to IntegerGradeBook
        integerGradeBook.addStudents();
        // Update a grade for the new student
        integerGradeBook.promptUpdateGrade();

        // Remove a student from IntegerGradeBook
        integerGradeBook.removeStudent();

        // Demonstrate DoubleGradeBook
        System.out.println("Running Double GradeBook:");
        doubleGradeBook.run();

        // Add a student to DoubleGradeBook
        doubleGradeBook.addStudents();

        // Update a grade for the new student
        doubleGradeBook.promptUpdateGrade();

        // Remove a student from DoubleGradeBook
        doubleGradeBook.removeStudent();

        // Close the scanner
        scanner.close();
    }
}
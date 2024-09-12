package main;

import validators.NameValidator;
import java.util.HashSet;
import java.util.Set;
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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class MainHashSet {
    public static void main(String[] args) {

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Double GradeBook setup
        InputValidator<Double> doubleValidator = new InputValidator<>(new DoubleValidator(), "double score");
        InputHandler<Double> doubleScoreInputHandler = new ConsoleInputHandler<>(scanner, doubleValidator);

        InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, new InputValidator<>(new NameValidator(), "name"));
        InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, new InputValidator<>(new PositiveIntegerValidator(), "count"));

        StudentRegistry<Student<Double>, Double> doubleStudentRegistry = StudentRegistry.getInstance();
        Supplier<Student<Double>> doubleStudentFactory = () -> new Student<>();

        // Declare and initialize the doubleGradeBook variable
        Set<String> uniqueNames = new HashSet<>(); // Create a HashSet for unique names
        DoubleGradeBook doubleGradeBook = new DoubleGradeBook(
                doubleStudentRegistry,
                nameInputHandler,
                countInputHandler,
                countInputHandler,
                new GradeEntrySystemImpl<>(doubleScoreInputHandler),
                new GradeCalculator<Student<Double>>() { // Use the correct generic type
                    @Override
                    public double calculateAverage(Student<Double> student) { // Implement the calculateAverage method
                        List<Double> grades = student.getGrades();
                        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    }
                },
                new GradebookDisplayImpl<Student<Double>>(),
                new ClassAverageCalculatorImpl<>(),
                doubleStudentFactory,
                uniqueNames
        );  

        // Demonstrate DoubleGradeBook
        System.out.println("Running Double Grade Book for HashSet of Unique Names:" + "\n");
        doubleGradeBook.run();

        // Demonstration of getUniqueNamesForHashSet
        List<String> sampleNames = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        Set<String> uniqueNames2 = new NameValidator().getUniqueNamesForHashSet(sampleNames);
        System.out.println("Unique names: " + uniqueNames2);

        // Close the scanner
        scanner.close();
    }
}
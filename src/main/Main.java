package main;

import dataModels.IntegerGradeBook;
import dataModels.Student;
import dataModels.StudentRegistryImpl;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;
import handlers.GradeEntrySystemImpl;
import validators.InputValidator;
import validators.NameValidator;
import validators.PositiveIntegerValidator;
import validators.ScoreValidator;
import dataManipulators.ClassAverageCalculatorImpl;
import dataManipulators.GradeCalculatorImpl;
import Displays.GradebookDisplayImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of dataModels.Student<Integer>
        List<Student<Integer>> studentList = new ArrayList<>();
        studentList.add(new Student<>("Alice"));
        studentList.add(new Student<>("Bob"));

        // Create input handlers
        Scanner scanner = new Scanner(System.in);
        InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
        InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

        InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
        InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

        InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
        InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

        // Create a StudentRegistry
        StudentRegistryImpl<Student<Integer>, Integer> studentRegistry = new StudentRegistryImpl<>();

        // Create an IntegerGradeBook
        Supplier<Student<Integer>> studentFactory = Student::new;
        IntegerGradeBook integerGradeBook = new IntegerGradeBook(
                studentRegistry,
                nameInputHandler,
                countInputHandler,
                countInputHandler,
                new GradeEntrySystemImpl<>(),
                new GradeCalculatorImpl<>(),
                new GradebookDisplayImpl<>(),
                new ClassAverageCalculatorImpl<>(),
                studentFactory
        );

        // Run the IntegerGradeBook
        integerGradeBook.run();

        // Close the scanner
        scanner.close();
    }
}
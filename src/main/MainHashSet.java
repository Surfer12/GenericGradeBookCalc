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

        // Demonstrate DoubleGradeBook
        System.out.println("Running Double Grade Book for HashSet of Unique Names:" + "\n");
        doubleGradeBook.run();

        // Demonstration of getUniqueNamesForHashSet
        List<String> sampleNames = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        Set<String> uniqueNames = new NameValidator().getUniqueNamesForHashSet(sampleNames);
        System.out.println("Unique names: " + uniqueNames);

        // Close the scanner
        scanner.close();
    }
}
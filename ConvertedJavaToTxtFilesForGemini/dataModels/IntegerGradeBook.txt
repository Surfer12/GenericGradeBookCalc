package dataModels;

import Displays.ConsoleGradebookDisplay;
import dataManipulators.AverageClassAverageCalculator;
import dataManipulators.SimpleGradeCalculator;
import handlers.ConsoleGradeEntrySystem;
import handlers.ConsoleInputHandler;
import validators.InputValidator;
import validators.NameValidator;
import validators.PositiveIntegerValidator;
import validators.ScoreValidator;

import java.util.Scanner;
import java.util.function.Supplier;

public class IntegerGradeBook extends GradeBook<Student<Integer>, Integer> {
    public IntegerGradeBook(Supplier<Student<Integer>> studentFactory) {
        super(new SimpleStudentRegistry<>(),
              new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new NameValidator(), "name")),
              new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new PositiveIntegerValidator(), "positive integer")),
                new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new PositiveIntegerValidator(), "positive integer")),
              new ConsoleGradeEntrySystem<>(new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new ScoreValidator(), "score"))),
              new SimpleGradeCalculator<>(),
              new ConsoleGradebookDisplay<>(),
              new AverageClassAverageCalculator<>(),
              studentFactory);
    }
}
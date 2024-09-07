package dataModels;

import Displays.ConsoleGradebookDisplay;
import dataManipulators.AverageClassAverageCalculator;
import dataManipulators.SimpleGradeCalculator;
import handlers.ConsoleGradeEntrySystem;
import handlers.ConsoleInputHandler;
import handlers.DoubleInputHandler;
import validators.InputValidator;
import validators.NameValidator;
import validators.PositiveIntegerValidator;

import java.util.Scanner;
import java.util.function.Supplier;

public class DoubleGradeBook extends GradeBook<Student<Double>, Double> {
    public DoubleGradeBook(Supplier<Student<Double>> studentFactory) {
        super(new SimpleStudentRegistry<>(),
              new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new NameValidator(), "name")),
              new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new PositiveIntegerValidator(), "positive integer")),
                new ConsoleInputHandler<>(new Scanner(System.in), new InputValidator<>(new PositiveIntegerValidator(), "positive integer")),
              new ConsoleGradeEntrySystem<Student<Double>, Double>(new DoubleInputHandler(new Scanner(System.in))),
              new SimpleGradeCalculator<>(),
              new ConsoleGradebookDisplay<>(),
              new AverageClassAverageCalculator<>(),
              studentFactory);
    }
}
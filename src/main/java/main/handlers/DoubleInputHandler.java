package src.main.java.main.handlers;

import validators.InputValidator;

import java.util.Scanner;

public class DoubleInputHandler extends ConsoleInputHandler<Double> {
    public DoubleInputHandler(Scanner scanner, InputValidator<Double> inputValidator) {
        super(scanner, inputValidator);
    }
}
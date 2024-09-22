package src.main.handlers;

import java.util.Scanner;

import src.main.validators.InputValidator;

public class DoubleInputHandler extends ConsoleInputHandler<Double> {
    public DoubleInputHandler(Scanner scanner, InputValidator<Double> inputValidator) {
        super(scanner, inputValidator);
    }
}
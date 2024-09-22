package main.java.handlers;

import java.util.Scanner;

import main.java.validators.InputValidator;

public class DoubleInputHandler extends ConsoleInputHandler<Double> {
    public DoubleInputHandler(Scanner scanner, InputValidator<Double> inputValidator) {
        super(scanner, inputValidator);
    }
}
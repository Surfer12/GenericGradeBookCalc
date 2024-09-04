import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler<T> implements InputHandler<T> {
    private final Scanner scanner;
    private final InputValidator<T> inputValidator;

    public ConsoleInputHandler(Scanner scanner, InputValidator<T> inputValidator) {
        this.scanner = scanner;
        this.inputValidator = inputValidator;
    }

    @Override
    public T getInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (inputValidator.isValid(input)) {
                try {
                    return inputValidator.parse(input);
                } catch (Exception e) {
                    System.out.println("Error parsing input. Please try again.");
                }
            }
        }
    }

    @Override
    public List<T> getMultipleInputs(String prompt, String stopCommand) {
        List<T> inputs = new ArrayList<>();
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(stopCommand)) {
                break;
            }
            if (inputValidator.isValid(input)) {
                try {
                    inputs.add(inputValidator.parse(input));
                } catch (Exception e) {
                    System.out.println("Error parsing input. Please try again.");
                }
            }
        }
        return inputs;
    }
}

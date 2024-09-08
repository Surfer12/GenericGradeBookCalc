package handlers;

import java.util.List;
import java.util.Scanner;

/**
 * An interface for handling input operations.
 *
 * @param <T> the type of input to handle
 */
public interface InputHandler<T> {

    /**
     * Prompts the user for input and returns the validated input.
     *
     * @param prompt the prompt to display to the user
     * @return the validated input of type T
     */
    T getInput(String prompt);

    /**
     * Prompts the user for multiple inputs until the stop command is entered.
     *
     * @param prompt      the prompt to display to the user
     * @param stopCommand the command to stop input collection
     * @return a list of validated inputs of type T
     */
    List<T> getMultipleInputs(String prompt, String stopCommand);
}

public class InputHandlerImpl<T> implements InputHandler<T> {
    private final Scanner scanner;

    public InputHandlerImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public T getInput(String prompt) {
        System.out.print(prompt);
        return (T) scanner.nextLine();
    }

    @Override
    public List<T> getMultipleInputs(String prompt, String stopCommand) {
        List<T> inputs = new ArrayList<>();
        String input;
        do {
            input = getInput(prompt);
            if (!input.equalsIgnoreCase(stopCommand)) {
                inputs.add((T) input);
            }
        } while (!input.equalsIgnoreCase(stopCommand));
        return inputs;
    }
}
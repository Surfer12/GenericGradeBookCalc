import java.util.List;

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
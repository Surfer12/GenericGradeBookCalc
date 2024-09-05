import java.util.Scanner;

public class DoubleInputHandler extends ConsoleInputHandler<Double> {
    public DoubleInputHandler(Scanner scanner) {
        super(scanner, new InputValidator<>(new DoubleValidator(), "double"));
    }
}
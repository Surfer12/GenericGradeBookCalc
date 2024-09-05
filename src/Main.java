import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Main class to run the GradeBook application.
 */
public class Main {

    /**
     * The main method to start the GradeBook application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // Debug: Start of the program
            System.out.println("Program started.");

            // Input handlers for name, score, and positive integers
            System.out.println("Initializing input handlers...");

            // Validator for name input
            InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
            // Handler for name input from console
            InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

            // Validator for score input
            InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
            // Handler for score input from console
            InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

            // Validator for positive integer input
            InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
            // Handler for positive integer input from console
            InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

            // Student factory for creating new student instances
            Supplier<Student<Integer>> studentFactory = Student::new;
            System.out.println("Student factory created.");

            // Create and initialize the GradeBook with all necessary components
            System.out.println("Creating GradeBook...");
            GradeBook<Student<Integer>, Integer> gradeBook = new GradeBook<>(
                    new SimpleStudentRegistry<>(),
                    nameInputHandler,
                    countInputHandler,
                    new ConsoleGradeEntrySystem<>(scoreInputHandler),
                    new SimpleGradeCalculator<>(),
                    new ConsoleGradebookDisplay<>(),
                    new AverageClassAverageCalculator<>(),
                    studentFactory
            );

            System.out.println("GradeBook created. Running GradeBook...");

            // Run the gradebook system
            gradeBook.run();

            System.out.println("GradeBook ran successfully.");

        } catch (Exception e) {
            // Handle any exceptions that occur during the execution
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the scanner to free up resources
            System.out.println("Closing scanner.");
        }
    }
}
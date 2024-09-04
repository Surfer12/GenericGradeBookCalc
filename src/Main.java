import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Debug: Start of the program
            System.out.println("Program started.");

            // Input handlers for name, score, and positive integers
            System.out.println("Initializing input handlers...");

            InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
            InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

            InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
            InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

            InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
            InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

            // Student factory for creating new student instances
            Supplier<Student<Integer>> studentFactory = () -> new Student<>();
            System.out.println("Student factory created.");

            // Create and initialize the GradeBook with all necessary components
            System.out.println("Creating GradeBook...");
            GradeBook<Student<Integer>> gradeBook = new GradeBook<>(
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
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the scanner to free up resources
            System.out.println("Closing scanner.");
            scanner.close();
        }
    }
}

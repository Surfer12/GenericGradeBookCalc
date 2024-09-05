import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Student<Integer>
        List<Student<Integer>> studentList = new ArrayList<>();
        studentList.add(new Student<>("Alice"));
        studentList.add(new Student<>("Bob"));

        // Create input handlers
        Scanner scanner = new Scanner(System.in);
        InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
        InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

        InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
        InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

        InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
        InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

        // Create a DoubleGradeBook
        Supplier<Student<Double>> studentFactory = Student::new;
        DoubleGradeBook doubleGradeBook = new DoubleGradeBook(
                new SimpleStudentRegistry<>(),
                nameInputHandler,
                countInputHandler,
                new ConsoleGradeEntrySystem<Student<Double>>(scoreInputHandler),
                new SimpleGradeCalculator<>(),
                new ConsoleGradebookDisplay<>(),
                new AverageClassAverageCalculator<>(),
                studentFactory
        );

        // Run the DoubleGradeBook
        doubleGradeBook.run();

        // Close the scanner
        scanner.close();
    }
}
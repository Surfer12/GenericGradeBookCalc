import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputValidator<String> nameValidator = new InputValidator<>(new NameValidator(), "name");
        InputHandler<String> nameInputHandler = new ConsoleInputHandler<>(scanner, nameValidator);

        InputValidator<Integer> scoreValidator = new InputValidator<>(new ScoreValidator(), "score");
        InputHandler<Integer> scoreInputHandler = new ConsoleInputHandler<>(scanner, scoreValidator);

        InputValidator<Integer> positiveIntValidator = new InputValidator<>(new PositiveIntegerValidator(), "positive integer");
        InputHandler<Integer> countInputHandler = new ConsoleInputHandler<>(scanner, positiveIntValidator);

        Supplier<Student> studentFactory = Student::new;

        GradeBook<Student> gradeBook = new GradeBook<>(
            new SimpleStudentRegistry<>(),
            nameInputHandler,
            countInputHandler,
            new ConsoleGradeEntrySystem<>(scoreInputHandler),
            new SimpleGradeCalculator<>(),
            new ConsoleGradebookDisplay<>(),
            new AverageClassAverageCalculator<>(),
            studentFactory
        );

        gradeBook.run();
        scanner.close();
    }
}

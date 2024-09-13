package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import dataModels.StudentRegistry;
import dataModels.IntegerGradeBook;
import dataManipulators.ClassAverageCalculatorImpl;
import Displays.GradebookDisplayImpl;
import handlers.GradeEntrySystemImpl;
import validators.NameValidator;
import validators.InputValidator;
import handlers.ConsoleInputHandler;
import validators.ScoreValidator;
import validators.PositiveIntegerValidator;

@Configuration
public class AppConfig {

    @Bean
    public StudentRegistry<Student<Integer>, Integer> studentRegistry() {
        return StudentRegistry.getInstance();
    }

    @Bean
    public GradeCalculator<Student<Integer>> gradeCalculator() {
        return student -> {
            List<Integer> grades = student.getGrades();
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        };
    }

    @Bean
    public IntegerGradeBook integerGradeBook(StudentRegistry<Student<Integer>, Integer> registry,
                                             InputHandler<String> nameInputHandler,
                                             InputHandler<Integer> countInputHandler,
                                             InputHandler<Integer> gradeInputHandler,
                                             GradeEntrySystemImpl<Integer> gradeEntrySystem,
                                             GradeCalculator<Student<Integer>> gradeCalculator,
                                             GradebookDisplayImpl<Student<Integer>> display,
                                             ClassAverageCalculatorImpl<Integer> averageCalculator) {
        return new IntegerGradeBook(
                registry,
                nameInputHandler,
                countInputHandler,
                gradeInputHandler,
                gradeEntrySystem,
                gradeCalculator,
                display,
                averageCalculator,
                () -> new Student<>(),
                new HashSet<>()
        );
    }

    // Other bean definitions...
}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IntegerGradeBook integerGradeBook = context.getBean(IntegerGradeBook.class);
        
        // Run the GradeBook
        integerGradeBook.run();
    }
}
package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dataModels.StudentRegistry;
import dataModels.IntegerGradeBook;
import handlers.InputHandler;
import handlers.ConsoleInputHandler;
import handlers.GradeEntrySystemImpl;
import validators.InputValidator;
import validators.NameValidator;
import validators.ScoreValidator;
import validators.PositiveIntegerValidator;
// ... other imports ...

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
    public IntegerGradeBook integerGradeBook(
            StudentRegistry<Student<Integer>, Integer> registry,
            InputHandler<String> nameInputHandler,
            InputHandler<Integer> countInputHandler,
            InputHandler<Integer> gradeInputHandler,
            GradeEntrySystemImpl<Student<Integer>, Integer> gradeEntrySystem, // Corrected
            GradeCalculator<Student<Integer>> gradeCalculator,
            GradebookDisplayImpl<Student<Integer>> display,
            ClassAverageCalculatorImpl<Student<Integer>> averageCalculator) { // Corrected
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

    // Define other beans similarly...
}
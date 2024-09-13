package main;

import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

import dataModels.StudentRegistry;
import dataModels.IntegerGradeBook;
import handlers.InputHandler;
import handlers.ConsoleInputHandler;
import handlers.GradeEntrySystemImpl;
import dataManipulators.GradeCalculator;
import Displays.GradebookDisplayImpl;
import dataManipulators.ClassAverageCalculatorImpl;
import dataModels.Student;

import java.util.HashSet;
import java.util.function.Supplier;
import java.util.Set;

@Factory
public class AppConfig {

    @Singleton
    public StudentRegistry<Student<Integer>, Integer> studentRegistry() {
        return StudentRegistry.getInstance();
    }

    @Singleton
    public GradeCalculator<Student<Integer>, Integer> gradeCalculator() {
        return student -> {
            return student.getGrades().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
        };
    }

    @Singleton
    public IntegerGradeBook integerGradeBook(
            StudentRegistry<Student<Integer>, Integer> registry,
            InputHandler<String> nameInputHandler,
            InputHandler<Integer> countInputHandler,
            InputHandler<Integer> gradeInputHandler,
            GradeEntrySystemImpl<Student<Integer>, Integer> gradeEntrySystem,
            GradeCalculator<Student<Integer>, Integer> gradeCalculator,
            GradebookDisplayImpl<Student<Integer>> display,
            ClassAverageCalculatorImpl<Student<Integer>> averageCalculator) {
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
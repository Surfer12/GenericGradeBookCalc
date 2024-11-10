package dataModels;

import handlers.InputHandler;
import handlers.GradeEntrySystem;
import handlers.GradebookDisplay;
import dataManipulators.GradeCalculator;
import dataManipulators.ClassAverageCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class IntegerGradeBookTest {
    private IntegerGradeBook gradeBook;
    private StudentRegistry<Student<Integer>, Integer> studentRegistry;
    private InputHandler<String> nameInputHandler;
    private InputHandler<Integer> countInputHandler;
    private InputHandler<Integer> assignmentCountInputHandler;
    private GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem;
    private GradeCalculator<Student<Integer>, Integer> gradeCalculator;
    private GradebookDisplay<Student<Integer>> gradebookDisplay;
    private ClassAverageCalculator<Student<Integer>> classAverageCalculator;
    private Supplier<Student<Integer>> studentFactory;
    private Set<String> uniqueNames;

    @BeforeEach
    public void setUp() {
        studentRegistry = mock(StudentRegistry.class);
        nameInputHandler = mock(InputHandler.class);
        countInputHandler = mock(InputHandler.class);
        assignmentCountInputHandler = mock(InputHandler.class);
        gradeEntrySystem = mock(GradeEntrySystem.class);
        gradeCalculator = mock(GradeCalculator.class);
        gradebookDisplay = mock(GradebookDisplay.class);
        classAverageCalculator = mock(ClassAverageCalculator.class);
        studentFactory = mock(Supplier.class);
        uniqueNames = new HashSet<>();

        gradeBook = new IntegerGradeBook(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem, gradeCalculator, gradebookDisplay,
                classAverageCalculator, studentFactory, uniqueNames);
    }
}
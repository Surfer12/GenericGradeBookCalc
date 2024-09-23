package dataModels; // Ensure this is correct

import handlers.InputHandler;
import handlers.GradeEntrySystem;
import dataManipulators.GradeCalculator;
import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataManipulators.ClassAverageCalculatorImpl;
import dataModels.Student;
import dataModels.StudentRegistry;
import inputHandlers.InputHandler;
import validators.GradeCalculator;
import validators.GradebookDisplay;
import validators.GradeEntrySystem;

import handlers.InputHandler; // Updated import
import handlers.GradeEntrySystem; // Updated import
import handlers.GradebookDisplay; // Updated import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class IntegerGradeBookTest {

   private InputHandler<String> nameInputHandler; // Ensure this class exists
   private InputHandler<Integer> countInputHandler; // Ensure this class exists
   private InputHandler<Integer> assignmentCountInputHandler; // Ensure this class exists
   private GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem; // Ensure this class exists
   private GradebookDisplay<Student<Integer>> gradebookDisplay; // Ensure this class exists

   @BeforeEach
   public void setUp() {
      nameInputHandler = mock(InputHandler.class); // Ensure this class exists
      countInputHandler = mock(InputHandler.class); // Ensure this class exists
      assignmentCountInputHandler = mock(InputHandler.class); // Ensure this class exists
      gradeEntrySystem = mock(GradeEntrySystem.class); // Ensure this class exists
      gradebookDisplay = mock(GradebookDisplay.class); // Ensure this class exists
   

   mock(StudentRegistry.class);
      nameInputHandler = mock(InputHandler.class);
      countInputHandler = mock(InputHandler.class);
      assignmentCountInputHandler = mock(InputHandler.class);
      gradeEntrySystem = mock(GradeEntrySystem.class);
      gradeCalculator = mock(GradeCalculator.class);
      gradebookDisplay = mock(GradebookDisplay.class);
      classAverageCalculator = mock(ClassAverageCalculator.class);
      studentFactory = mock(Supplier.class);
      uniqueNames = new HashSet<>();
import static org.mockito.Mockito.mock;

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
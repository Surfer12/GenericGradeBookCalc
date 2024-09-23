package dataModels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import handlers.InputHandler;
import handlers.GradeEntrySystem; // Updated import
import handlers.GradebookDisplay; // Updated import
import handlers.StudentRegistry; // Updated import
import dataManipulators.ClassAverageCalculator;
import dataModels.Student;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataManipulators.ClassAverageCalculatorImpl;
import dataManipulators.ClassAverageCalculator;
import Displays.GradebookDisplay;
import handlers.GradeEntrySystem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoubleGradeBookTest {

   private DoubleGradeBook doubleGradeBook;
   private StudentRegistry<Student<Double>, Double> studentRegistry;
   private InputHandler<String> nameInputHandler;
   private InputHandler<Integer> countInputHandler;
   private InputHandler<Integer> assignmentCountInputHandler;
   private GradeEntrySystem<Student<Double>, Double> gradeEntrySystem; // Ensure this class exists
   private GradeCalculator<Student<Double>, Double> gradeCalculator;
   private GradebookDisplay<Student<Double>> gradebookDisplay; // Ensure this class exists
   private ClassAverageCalculator<Student<Double>> classAverageCalculator;
   private Supplier<Student<Double>> studentFactory;
   private Set<String> uniqueNames;

   @BeforeEach
   public void setUp() {
      studentRegistry = mock(StudentRegistry.class);
      nameInputHandler = mock(InputHandler.class);
      countInputHandler = mock(InputHandler.class);
      assignmentCountInputHandler = mock(InputHandler.class);
      gradeEntrySystem = mock(GradeEntrySystem.class); // Ensure this class exists
      gradeCalculator = mock(GradeCalculator.class);
      gradebookDisplay = mock(GradebookDisplay.class); // Ensure this class exists
      classAverageCalculator = mock(ClassAverageCalculator.class);
      studentFactory = mock(Supplier.class);
      uniqueNames = new HashSet<>();

      doubleGradeBook = new DoubleGradeBook(studentRegistry, nameInputHandler, countInputHandler,
            assignmentCountInputHandler, gradeEntrySystem, gradeCalculator, gradebookDisplay,
            classAverageCalculator, studentFactory, uniqueNames);
   }

   @Test
   public void testCalculateAverageWithEmptyList() {
      ClassAverageCalculatorImpl<TestStudent> calculator = new ClassAverageCalculatorImpl<>();
      List<TestStudent> students = Collections.emptyList();
      double result = calculator.calculateAverage(students);
      assertEquals(0, result, "The average of an empty list should be 0");
   }
}

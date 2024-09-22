package test.java.dataModels;

import dataModels.AbstractGradeBook;
import dataModels.Student;
import dataModels.StudentRegistry;
import handlers.InputHandler;
import handlers.GradeEntrySystem;
import dataManipulators.GradeCalculator;
import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AbstractGradeBookTest {

   @Mock
   private StudentRegistry<Student<Double>, Double> studentRegistry;
   @Mock
   private InputHandler<String> nameInputHandler;
   @Mock
   private InputHandler<Integer> countInputHandler;
   @Mock
   private InputHandler<Integer> assignmentCountInputHandler;
   @Mock
   private GradeEntrySystem<Student<Double>, Double> gradeEntrySystem;
   @Mock
   private GradeCalculator<Student<Double>, Double> gradeCalculator;
   @Mock
   private GradebookDisplay<Student<Double>> gradebookDisplay;
   @Mock
   private ClassAverageCalculator<Student<Double>> classAverageCalculator;
   @Mock
   private Supplier<Student<Double>> studentFactory;

   private AbstractGradeBook<Student<Double>, Double> gradeBook;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
      gradeBook = new AbstractGradeBook<Student<Double>, Double>(
            studentRegistry,
            nameInputHandler,
            countInputHandler,
            assignmentCountInputHandler,
            gradeEntrySystem,
            gradeCalculator,
            gradebookDisplay,
            classAverageCalculator,
            studentFactory,
            new HashSet<>()) {
         @Override
         public void run() {
            // Implementation not needed for tests
         }

         @Override
         public List<Student<Double>> addStudents() {
            return new ArrayList<>();
         }

         @Override
         public void removeStudent() {
            // Implementation not needed for tests
         }

         @Override
         public Optional<Student<Double>> promptUpdateGrade() {
            return Optional.empty();
         }
      };
   }

   @Test
   void testGetStudentCount() {
      when(countInputHandler.getInput(anyString())).thenReturn(5);
      int count = gradeBook.getStudentCount();
      assertEquals(5, count);
      verify(countInputHandler).getInput(eq("Enter the number of students: "));
   }

   @Test
   void testRegisterStudents() {
      when(studentFactory.get()).thenReturn(new Student<>());
      when(nameInputHandler.getInput(anyString())).thenReturn("John Doe");
      when(assignmentCountInputHandler.getInput(anyString())).thenReturn(3);

      List<Student<Double>> students = gradeBook.registerStudents(2);

      assertEquals(2, students.size());
      verify(studentRegistry, times(2)).addStudent(any());
   }

   @Test
   void testRegisterStudent() {
      when(studentFactory.get()).thenReturn(new Student<>());
      when(nameInputHandler.getInput(anyString())).thenReturn("John Doe");
      when(assignmentCountInputHandler.getInput(anyString())).thenReturn(3);

      Student<Double> student = gradeBook.registerStudent();

      assertNotNull(student);
      assertEquals("John Doe", student.getName());
      assertEquals(3, student.getAssignmentCount());
      verify(studentRegistry).addStudent(student);
   }

   @Test
   void testEnterGrades() {
      Student<Double> student = new Student<>();
      student.setAssignmentCount(2);
      List<Student<Double>> students = List.of(student);

      when(gradeEntrySystem.enterGradeForAssignment(any(), anyInt())).thenReturn(95.0, 85.0);

      gradeBook.enterGrades(students);

      assertEquals(2, student.getGrades().size());
      assertEquals(95.0, student.getGrades().get(0));
      assertEquals(85.0, student.getGrades().get(1));
   }

   @Test
   void testCalculateGrades() {
      Student<Double> student = new Student<>();
      student.addGrade(95.0);
      student.addGrade(85.0);
      List<Student<Double>> students = List.of(student);

      when(gradeCalculator.calculateAverage(any())).thenReturn(90.0);

      gradeBook.calculateGrades(students);

      assertEquals(90.0, student.getAverage());
   }

   @Test
   void testGetNewStudentCount() {
      when(countInputHandler.getInput(anyString())).thenReturn(3);
      int count = gradeBook.getNewStudentCount();
      assertEquals(3, count);
      verify(countInputHandler).getInput(eq("Enter the number of new students: "));
   }

   @Test
   void testDisplayResults() {
      List<Student<Double>> students = new ArrayList<>();
      when(classAverageCalculator.calculateAverage(any())).thenReturn(90.0);

      gradeBook.displayResults(students);

      verify(gradebookDisplay).display(students);
      verify(classAverageCalculator).calculateAverage(students);
   }
}

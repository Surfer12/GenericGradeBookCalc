package handlers;

import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mock;

import dataModels.Student;
import org.mockito.MockitoAnnotations;


class ConsoleGradeEntrySystemTest {

   @Mock
   private InputHandler<Integer> mockInputHandler;

   @Mock
   private Student<Integer> mockStudent;

   private ConsoleGradeEntrySystem<Student<Integer>, Integer> consoleGradeEntrySystem;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
      consoleGradeEntrySystem = new ConsoleGradeEntrySystem<>(mockInputHandler);
   }

   @Test
   void testEnterGradeForAssignment() {
      // Arrange
      int assignmentNumber = 1;
      int expectedGrade = 95;
      when(mockStudent.getName()).thenReturn("John Doe");
      when(mockInputHandler.getInput("Enter grade for John Doe for assignment 1: ")).thenReturn(expectedGrade);

      // Act
      int actualGrade = consoleGradeEntrySystem.enterGradeForAssignment(mockStudent, assignmentNumber);

      // Assert
      assertEquals(expectedGrade, actualGrade);
      verify(mockInputHandler).getInput("Enter grade for John Doe for assignment 1: ");
   }
}
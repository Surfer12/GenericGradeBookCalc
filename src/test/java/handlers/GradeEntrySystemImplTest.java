package handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import dataModels.Student;

class GradeEntrySystemImplTest {

   @Mock
   private InputHandler<Number> gradeInputHandler;

   private GradeEntrySystemImpl<Student<Number>, Number> gradeEntrySystem;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
      gradeEntrySystem = new GradeEntrySystemImpl<>(gradeInputHandler);
   }

   @Test
   void testEnterGradeForAssignment() {
      // Arrange
      Student<Number> student = mock(Student.class);
      when(student.getName()).thenReturn("John Doe");
      when(gradeInputHandler.getInput("Enter grade for John Doe for assignment 1: ")).thenReturn(95);

      // Act
      Number grade = gradeEntrySystem.enterGradeForAssignment(student, 1);

      // Assert
      assertEquals(95, grade);
      verify(gradeInputHandler).getInput("Enter grade for John Doe for assignment 1: ");
   }
}
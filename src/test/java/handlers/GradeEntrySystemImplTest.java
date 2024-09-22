import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

package handlers;

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
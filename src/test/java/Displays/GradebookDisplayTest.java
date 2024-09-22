
package Displays;

import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GradebookDisplayTest {

   private GradebookDisplay<Student<?>> gradebookDisplay;
   private List<Student<?>> students;

   @BeforeEach
   void setUp() {
      // Create a mock implementation of GradebookDisplay
      gradebookDisplay = mock(GradebookDisplay.class);

      // Create a list of mock students
      students = new ArrayList<>();
      students.add(mock(Student.class));
      students.add(mock(Student.class));
   }

   @Test
   void testDisplay() {
      // Test that the display method can be called without throwing an exception
      assertDoesNotThrow(() -> gradebookDisplay.display(students));

      // Verify that the display method was called with the correct list of students
      gradebookDisplay.display(students);
      verify(gradebookDisplay).display(students);
   }
}
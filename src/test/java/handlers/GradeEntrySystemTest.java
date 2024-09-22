package handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dataModels.Student;



class GradeEntrySystemTest {

   private GradeEntrySystem<Student<Double>, Double> gradeEntrySystem;
   private Student<Double> student;

   @BeforeEach
   void setUp() {
      // Mocking the student and grade entry system for testing
      student = mock(Student.class);
      gradeEntrySystem = mock(GradeEntrySystem.class);
   }

   @Test
   void testEnterGradeForAssignment() {
      int assignmentNumber = 1;
      Double expectedGrade = 95.0;

      // Mocking the behavior of enterGradeForAssignment
      when(gradeEntrySystem.enterGradeForAssignment(student, assignmentNumber)).thenReturn(expectedGrade);

      // Calling the method to test
      Double actualGrade = gradeEntrySystem.enterGradeForAssignment(student, assignmentNumber);

      // Verifying the result
      assertEquals(expectedGrade, actualGrade);

      // Verifying the interaction
      verify(gradeEntrySystem).enterGradeForAssignment(student, assignmentNumber);
   }
}
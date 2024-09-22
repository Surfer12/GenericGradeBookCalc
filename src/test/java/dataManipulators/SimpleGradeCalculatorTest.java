package dataManipulators;

import dataModels.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleGradeCalculatorTest {

   private SimpleGradeCalculator<Student<Number>, Number> gradeCalculator;

   @BeforeEach
   void setUp() {
      gradeCalculator = new SimpleGradeCalculator<>();
   }

   @Test
   void testCalculateAverageWithGrades() {
      Student<Number> student = new Student<Number>() {
         @Override
         public List<Number> getGrades() {
            return Arrays.asList(90, 80, 70);
         }
      };

      double average = gradeCalculator.calculateAverage(student);
      assertEquals(80.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithNoGrades() {
      Student<Number> student = new Student<Number>() {
         @Override
         public List<Number> getGrades() {
            return Arrays.asList();
         }
      };

      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithSingleGrade() {
      Student<Number> student = new Student<Number>() {
         @Override
         public List<Number> getGrades() {
            return Arrays.asList(100);
         }
      };

      double average = gradeCalculator.calculateAverage(student);
      assertEquals(100.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithDifferentNumberTypes() {
      Student<Number> student = new Student<Number>() {
         @Override
         public List<Number> getGrades() {
            return Arrays.asList(90, 85.5, 78.3);
         }
      };

      double average = gradeCalculator.calculateAverage(student);
      assertEquals(84.6, average, 0.01);
   }
}

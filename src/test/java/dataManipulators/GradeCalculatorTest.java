package dataManipulators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class GradeCalculatorTest {

   private GradeProcessor<StudentImpl, Integer> gradeCalculator;

   @BeforeEach
   void setUp() {
      gradeCalculator = student -> {
         List<Integer> grades = student.getGrades();
         return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
      };
   }

   @Test
   void testCalculateAverage() {
      StudentImpl student = new StudentImpl(Arrays.asList(90, 80, 70));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(80.0, average, 0.01);
   }

   // Additional test cases can be added here

   // Mock implementation of Student class for testing
   static class StudentImpl extends Student<Integer> {
      private final List<Integer> grades;

      StudentImpl(List<Integer> grades) {
         this.grades = grades;
      }

      @Override
      public List<Integer> getGrades() {
         return grades;
      }
   }
}
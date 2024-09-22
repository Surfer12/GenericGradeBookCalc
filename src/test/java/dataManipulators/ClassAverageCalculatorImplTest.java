package dataManipulators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dataModels.Student;

class ClassAverageCalculatorImplTest {

   static class TestStudent extends Student<Double> {
      private final double average;

      public TestStudent(double average) {
         this.average = average;
      }

      public Double getAverage() {
         return average;
      }
   }

   @Test
   void testCalculateAverageWithEmptyList() {
      ClassAverageCalculatorImpl<TestStudent> calculator = new ClassAverageCalculatorImpl<>();
      List<TestStudent> students = Collections.emptyList();
      double result = calculator.calculateAverage(students);
      assertEquals(0, result, "The average of an empty list should be 0");
   }

   @Test
   void testCalculateAverageWithSingleStudent() {
      ClassAverageCalculatorImpl<TestStudent> calculator = new ClassAverageCalculatorImpl<>();
      List<TestStudent> students = Collections.singletonList(new TestStudent(85.0));
      double result = calculator.calculateAverage(students);
      assertEquals(85.0, result, "The average of a single student should be the student's average");
   }

   @Test
   void testCalculateAverageWithMultipleStudents() {
      ClassAverageCalculatorImpl<TestStudent> calculator = new ClassAverageCalculatorImpl<>();
      List<TestStudent> students = Arrays.asList(
            new TestStudent(80.0),
            new TestStudent(90.0),
            new TestStudent(100.0));
      double result = calculator.calculateAverage(students);
      assertEquals(90.0, result, 0.001, "The average of multiple students should be correctly calculated");
   }
}
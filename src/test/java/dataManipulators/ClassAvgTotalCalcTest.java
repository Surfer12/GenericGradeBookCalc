package dataManipulators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dataModels.Student;



class ClassAvgTotalCalcTest {

   static class TestStudent extends Student<Double> {
      private final List<Double> grades;

      public TestStudent(List<Double> grades) {
         this.grades = grades;
      }

      @Override
      public List<Double> getGrades() {
         return grades;
      }
   }

   @Test
   void testCalculateClassAverageWithMultipleStudents() {
      ClassAvgTotalCalc<TestStudent, Double> calc = new ClassAvgTotalCalc<>();
      List<TestStudent> students = Arrays.asList(
            new TestStudent(Arrays.asList(90.0, 80.0, 70.0)),
            new TestStudent(Arrays.asList(60.0, 50.0, 40.0))
      );

      double result = calc.calculateClassAverage(students);
      assertEquals(65.0, result, 0.001);
   }

   @Test
   void testCalculateClassAverageWithSingleStudent() {
      ClassAvgTotalCalc<TestStudent, Double> calc = new ClassAvgTotalCalc<>();
      List<TestStudent> students = Collections.singletonList(
            new TestStudent(Arrays.asList(100.0, 90.0, 80.0))
      );

      double result = calc.calculateClassAverage(students);
      assertEquals(90.0, result, 0.001);
   }

   @Test
   void testCalculateClassAverageWithNoStudents() {
      ClassAvgTotalCalc<TestStudent, Double> calc = new ClassAvgTotalCalc<>();
      List<TestStudent> students = Collections.emptyList();

      double result = calc.calculateClassAverage(students);
      assertEquals(0.0, result, 0.001);
   }

   @Test
   void testCalculateClassAverageWithEmptyGrades() {
      ClassAvgTotalCalc<TestStudent, Double> calc = new ClassAvgTotalCalc<>();
      List<TestStudent> students = Arrays.asList(
            new TestStudent(Collections.emptyList()),
            new TestStudent(Collections.emptyList())
      );

      double result = calc.calculateClassAverage(students);
      assertEquals(0.0, result, 0.001);
   }
}
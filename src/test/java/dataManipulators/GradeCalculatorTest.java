package dataManipulators; // Ensure this is correct

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*; // Import Mockito
import static org.junit.jupiter.api.Assertions.*; // Import assertions
import dataModels.StudentImpl; // Ensure this class exists
import handlers.GradeProcessor; // Updated import

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import reactive.GradeProcessor;
import dataModels.Student;
import reactive.GradeStrategy;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import java.util.ArrayList;

class GradeCalculatorTest {
   private List<Integer> grades = new ArrayList<Integer>();

   @Mock
   private Student<Integer> studentMock;

   @BeforeEach
   public void setUp() {
      gradeCalculator = mock(GradeProcessor.class);
   }

   @Mock
   private GradeStrategy gradeStrategyMock;

   @Mock

   public class GradeCalculatorTest {
    private GradeProcessor<StudentImpl, Integer> gradeCalculator; // Ensure this class exists

   

   @BeforeEach
   void setUp() {
      gradeCalculator = new GradeProcessor(gradeStrategyMock);
   }

   @Test
   void testCalculateAverage() {
      List<Integer> grades = Arrays.asList(90, 80, 70);
      Student<Integer> student = new Student<>(grades);
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(80.0, average, 0.01);
      
      Student<Integer> student2 = new Student<Integer>(Arrays.asList(95, 82, 67, 54, 88));
      double average2 = gradeCalculator.calculateAverage(student2);
      assertEquals(71.6, average2, 0.01);
   }

   @Test
   void testCalculateAverageWithEmptyGrades() {
      Student<Integer> student = new Student<Integer>(Collections.emptyList());
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }     

   @Test
   void testCalculateAverageWithNullGrades() {
      Student<Integer> student = new Student(null);
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithNegativeGrades() {
      Student<Integer> student = new Student(Arrays.asList(-10, 20, -30, 40, -50));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(10.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithLargeGrades() {
      Student<Integer> student = new Student(Arrays.asList(100, 99, 98, 97, 96));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(97.6, average, 0.01);
   }

   @Test
   void testCalculateAverageWithSingleGrade() {
      Student<Integer> student = new Student(Arrays.asList(75));   
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(75.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithMultipleGrades() {
      Student<Integer> student = new Student(Arrays.asList(85, 90, 88, 92, 87));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(86.4, average, 0.01);
   }

   @Test
   void testCalculateAverageWithNullStudent() {
      Student<Integer> student = null;
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }
}
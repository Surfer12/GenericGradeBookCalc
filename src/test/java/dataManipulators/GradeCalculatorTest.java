package dataManipulators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import reactive.GradeProcessor;
import dataModels.Student;
import reactive.GradeStrategy;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class) // Add this line to enable Mockito
class GradeCalculatorTest {

   @Mock
   private Student<Integer> studentMock;

   @Mock
   private GradeStrategy gradeStrategyMock;

   private GradeProcessor gradeCalculator;

   @BeforeEach
   void setUp() {
      gradeCalculator = new GradeProcessor(gradeStrategyMock);
   }

   @Test
   void testCalculateAverage() {
      StudentImpl student = new StudentImpl(Arrays.asList(90, 80, 70));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(80.0, average, 0.01);
      
      StudentImpl student2 = new StudentImpl(Arrays.asList(95, 82, 67, 54, 88));
      double average2 = gradeCalculator.calculateAverage(student2);
      assertEquals(71.6, average2, 0.01);
   }

   @Test
   void testCalculateAverageWithEmptyGrades() {
      StudentImpl student = new StudentImpl(Collections.emptyList());
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }     

   @Test
   void testCalculateAverageWithNullGrades() {
      StudentImpl student = new StudentImpl(null);
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(0.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithNegativeGrades() {
      StudentImpl student = new StudentImpl(Arrays.asList(-10, 20, -30, 40, -50));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(10.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithLargeGrades() {
      StudentImpl student = new StudentImpl(Arrays.asList(100, 99, 98, 97, 96));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(97.6, average, 0.01);
   }

   @Test
   void testCalculateAverageWithSingleGrade() {
      StudentImpl student = new StudentImpl(Arrays.asList(75));   
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(75.0, average, 0.01);
   }

   @Test
   void testCalculateAverageWithMultipleGrades() {
      StudentImpl student = new StudentImpl(Arrays.asList(85, 90, 88, 92, 87));
      double average = gradeCalculator.calculateAverage(student);
      assertEquals(86.4, average, 0.01);
   }

   @Test
   void testCalculateAverageWithNullStudent() {
      double average = gradeCalculator.calculateAverage(null);
      assertEquals(0.0, average, 0.01);
   }
}
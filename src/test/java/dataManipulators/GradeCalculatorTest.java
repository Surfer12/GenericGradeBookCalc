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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactive.GradeProcessor;
import reactive.GradeStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeCalculatorTest {
    @Mock
    private Student<Integer> studentMock;

    @Mock
    private GradeStrategy gradeStrategyMock;

    @BeforeEach
    public void setUp() {
        gradeCalculator = mock(GradeProcessor.class);
    }

   @Mock

public class GradeCalculatorTest {
    private GradeProcessor<StudentImpl, Integer> gradeCalculator; // Ensure this class exists

   
    private GradeProcessor gradeCalculator;

    @BeforeEach
    void setUp() {
        gradeCalculator = new GradeProcessor(gradeStrategyMock, () -> new PassFailGradeStrategy());
    }

    @Test
    void testCalculateAverage() {
        Student<Integer> student = new Student<>("Test Student", Arrays.asList(90, 80, 70));
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(80.0, average, 0.01);


        List<Integer> grades2 = Arrays.asList(75, 72, 73, 74, 71);
        Student<Integer> student2 = new Student<>("Test Student 2", grades2);
        double average2 = gradeCalculator.calculateAverage(student2);
        assertEquals(72.8, average2, 0.01);
    }

    @Test
    void testCalculateAverageWithEmptyGrades() {
        Student<Integer> student = new Student<Integer>("Test Student", Collections.emptyList());
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(0.0, average, 0.01);
    }

    @Test
    void testCalculateAverageWithNullGrades() {
        Student<Integer> student = new Student<Integer>("Test Student", null);
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(0.0, average, 0.01);
    }

    @Test
    void testCalculateAverageWithNegativeGrades() {
        Student<Integer> student = new Student<Integer>("Test Student", Arrays.asList(-10, 20, -30, 40, -50));
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(10.0, average, 0.01);
    }

    @Test
    void testCalculateAverageWithLargeGrades() {
        Student<Integer> student = new Student<Integer>("Test Student", Arrays.asList(100, 99, 98, 97, 96));
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(97.6, average, 0.01);
    }

    @Test
    void testCalculateAverageWithSingleGrade() {
        Student<Integer> student = new Student<Integer>("Test Student", List.of(75));
        double average = gradeCalculator.calculateAverage(student);
        assertEquals(75.0, average, 0.01);
    }

    @Test
    void testCalculateAverageWithMultipleGrades() {
        Student<Integer> student = new Student<Integer>("Test Student", Arrays.asList(85, 90, 88, 92, 87));
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
package dataManipulators;

import dataModels.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageClassAverageCalculatorTest {

    @Test
    void testCalculateAverageWithMultipleStudents() {
        List<MockStudent> students = Arrays.asList(
                new MockStudent(Arrays.asList(90.0, 80.0, 70.0)),
                new MockStudent(Arrays.asList(60.0, 50.0, 40.0)),
                new MockStudent(Arrays.asList(100.0, 90.0, 80.0)));

        AverageClassAverageCalculator<MockStudent> calculator = new AverageClassAverageCalculator<>();
        double average = calculator.calculateAverage(students);

        assertEquals(70.0, average, 0.001);
    }

    @Test
    void testCalculateAverageWithNoStudents() {
        List<MockStudent> students = Collections.emptyList();

        AverageClassAverageCalculator<MockStudent> calculator = new AverageClassAverageCalculator<>();
        double average = calculator.calculateAverage(students);

        assertEquals(0.0, average, 0.001);
    }

    @Test
    void testCalculateAverageWithSingleStudent() {
        List<MockStudent> students = Collections.singletonList(
                new MockStudent(Arrays.asList(100.0, 90.0, 80.0)));

        AverageClassAverageCalculator<MockStudent> calculator = new AverageClassAverageCalculator<>();
        double average = calculator.calculateAverage(students);

        assertEquals(90.0, average, 0.001);
    }

    @Test
    void testCalculateAverageWithEmptyGrades() {
        List<MockStudent> students = Arrays.asList(
                new MockStudent(Collections.emptyList()),
                new MockStudent(Collections.emptyList()));

        AverageClassAverageCalculator<MockStudent> calculator = new AverageClassAverageCalculator<>();
        double average = calculator.calculateAverage(students);

        assertEquals(0.0, average, 0.001);
    }

    // Mock Student class for testing
    static class MockStudent extends Student<Double> {
        private List<Double> grades;

        public MockStudent(List<Double> grades) {
            this.grades = grades;
        }

        @Override
        public List<Double> getGrades() {
            return grades;
        }
    }
}
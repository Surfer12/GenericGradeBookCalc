package dataManipulators; // Ensure this is correct

import dataModels.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dataModels.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassAverageCalculatorTest {

    @Test
    void testCalculateAverage() {
        ClassAverageCalculator<TestStudent> calculator = new SimpleClassAverageCalculator();

        List<TestStudent> students = Arrays.asList(
                new TestStudent(90.0),
                new TestStudent(80.0),
                new TestStudent(70.0));

        double average = calculator.calculateAverage(students);
        assertEquals(80.0, average, 0.001);
    }

    @Test
    void testCalculateAverageEmptyList() {
        ClassAverageCalculator<TestStudent> calculator = new SimpleClassAverageCalculator();

        List<TestStudent> students = List.of();

        double average = calculator.calculateAverage(students);
        assertEquals(0.0, average, 0.001);
    }

    private static class TestStudent extends Student<Double> {
        private final double score;

        public TestStudent(double score) {
            this.score = score;
        }

        @Override
        public double getScore() {
            return score;
        }
    }

    private static class SimpleClassAverageCalculator implements ClassAverageCalculator<TestStudent> {
        @Override
        public double calculateAverage(List<TestStudent> students) {
            return students.stream()
                    .mapToDouble(TestStudent::getScore)
                    .average()
                    .orElse(0.0);
        }
    }
}
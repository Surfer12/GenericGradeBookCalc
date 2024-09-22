package GenericGradeBookCalc;

import dataModels.Student;
import dataManipulators.AverageClassAverageCalculator;

import java.util.HashSet;
import java.util.Set;

/**
 * **Class**
 * GenericGradeBookCalc.MainHashSet
 * <p>
 * **Description**
 * Main class to demonstrate the usage of the grade book.
 */
public class MainHashSet {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        // Add students to the set
        AverageClassAverageCalculator<Student> calculator = new AverageClassAverageCalculator<>();
        double average = calculator.calculateAverage(new ArrayList<>(students));
        System.out.println("Average: " + average);
    }
}
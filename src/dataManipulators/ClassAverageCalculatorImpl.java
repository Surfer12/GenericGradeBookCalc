package dataManipulators; // Changed from "main" to "dataManipulators"
import dataModels.Student;
import java.util.List;

public class ClassAverageCalculatorImpl<S extends Student<?>> implements ClassAverageCalculator<S> {
    // ... (existing code)

    @Override
    public double calculateAverage(List<S> students) {
        if (students == null || students.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (S student : students) {
            total += student.getAverage(); // Changed from getGrade() to getAverage()
        }
        return total / students.size();
    }
}
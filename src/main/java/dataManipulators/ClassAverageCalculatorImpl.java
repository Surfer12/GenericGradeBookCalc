package main.java.dataManipulators;  

import java.util.List;

import main.java.dataModels.Student;

public class ClassAverageCalculatorImpl<S extends Student<?>> implements ClassAverageCalculator<S> {
    @Override
    public double calculateAverage(List<S> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (S student : students) {
            sum += student.getAverage();
        }
        return sum / students.size();
    }
}
package main; // Changed from dataManipulators to main

import dataModels.Student;
import dataManipulators.ClassAverageCalculator; // Ensure this import is present

import java.util.List;

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
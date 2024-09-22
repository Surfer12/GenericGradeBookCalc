package main.java.Displays;

import java.util.List;

import main.java.dataModels.Student;

public class GradebookDisplayImpl<S extends Student<?>> implements GradebookDisplay<S> {
    @Override
    public void display(List<S> students) {
        for (S student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Grades: " + student.getGradesAsString());
            System.out.printf("Average: %.2f%n", student.getAverage());
            System.out.println("--------------------");
        }
    }
}
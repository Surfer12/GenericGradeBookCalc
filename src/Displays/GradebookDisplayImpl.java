package Displays;

import dataModels.Student;

import java.util.List;

/**
 * An interface for displaying a list of students in a gradebook.
 *
 * @param <S> the type of student to display, which extends the dataModels.Student class
 */
public interface GradebookDisplay<S extends Student<?>> {

    /**
     * Displays a list of students.
     *
     * @param students the list of students to display
     */
    void display(List<S> students);
}

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

    @Override
    public void displayGradebook(List<S> students) {
        for (S student : students) {
            System.out.println("Student: " + student.getName());
            List<?> grades = student.getGrades();
            if (grades.isEmpty()) {
                System.out.println("  No grades recorded");
            } else {
                System.out.println("  Grades: " + grades);
                System.out.println("  Average: " + student.getAverageScore());
            }
        }
    }
}
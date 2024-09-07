package Displays;

import dataModels.Student;

import java.util.List;

/**
 * A class that implements the Displays.GradebookDisplay interface to display the gradebook information in the console.
 *
 * @param <S> the type of student in the gradebook
 */
public class ConsoleGradebookDisplay<S extends Student<?>> implements GradebookDisplay<S> {
    // Header for the gradebook display table
    private static final String HEADER = "| dataModels.Student  | Grades               | Avg  |";
    // Separator line for the gradebook display table
    private static final String SEPARATOR = "-----------------------------------------";
    // Format string for displaying each student's information
    private static final String STUDENT_FORMAT = "| %-7s | %-20s | %.1f |";

    /**
     * Displays the gradebook information for a list of students in the console.
     *
     * @param students the list of students to display
     */
    @Override
    public void display(List<S> students) {
        // Print the table separator
        System.out.println(SEPARATOR);
        // Print the table header
        System.out.println(HEADER);
        // Print another table separator
        System.out.println(SEPARATOR);

        // Iterate over each student and print their information
        for (S student : students) {
            // Print the student's name, grades, and average grade
            System.out.printf(STUDENT_FORMAT, student.getName(), student.getGradesAsString(), student.getAverage());
            System.out.println();
        }

        // Print the final table separator
        System.out.println(SEPARATOR);
    }
}
package Displays;

import java.util.List;
import javax.inject.Singleton;

import src.main.dataModels.Student;

/**
 * Displays the gradebook information in a formatted table in the console.
 *
 * @param <S> the type of student in the gradebook
 */
@Singleton
public class ConsoleGradebookDisplay<S extends Student<?>> implements GradebookDisplay<S> {
    // Header for the gradebook display table
    private static final String HEADER = "| Student    | Grades               | Avg  |";
    // Separator line for the gradebook display table
    private static final String SEPARATOR = "-----------------------------------------";
    // Format string for displaying each student's information
    private static final String STUDENT_FORMAT = "| %-10s | %-20s | %.1f |";

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
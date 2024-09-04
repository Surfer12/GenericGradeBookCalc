import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SimpleStudentRegistry<Student<Integer>> registry = new SimpleStudentRegistry<>();
        try {
            // Add students to the registry
            registry.addStudent(new Student<>("John Doe", List.of(90, 85, 92)));
            registry.addStudent(new Student<>("Jane Smith", List.of(88, 79, 95)));

            // Display students
            GradebookDisplay<Student<Integer>> display = new ConsoleGradebookDisplay<>();
            display.display(registry.getAllStudents());

            // Calculate average
            ClassAverageCalculator<Student<Integer>> calculator = new AverageClassAverageCalculator<>();
            double average = calculator.calculateAverage(registry.getAllStudents());
            System.out.println("Class Average: " + average);
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logging framework
        }
    }
}
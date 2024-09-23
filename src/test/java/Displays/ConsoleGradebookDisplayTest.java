package Displays;

import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConsoleGradebookDisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ConsoleGradebookDisplay<Student<?>> display;

    @BeforeEach
    public void setUp() {
        display = new ConsoleGradebookDisplay<>();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplay() {
        // Create mock students
        Student<?> student1 = Mockito.mock(Student.class);
        Student<?> student2 = Mockito.mock(Student.class);

        // Define mock behavior
        Mockito.when(student1.getName()).thenReturn("Alice");
        Mockito.when(student1.getGradesAsString()).thenReturn("90, 85, 88");
        Mockito.when(student1.getAverage()).thenReturn(87.7);

        Mockito.when(student2.getName()).thenReturn("Bob");
        Mockito.when(student2.getGradesAsString()).thenReturn("75, 80, 70");
        Mockito.when(student2.getAverage()).thenReturn(75.0);

        // Create a list of mock students
        List<Student<?>> students = Arrays.asList(student1, student2);

        // Call the display method
        display.display(students);

        // Define the expected output
        String expectedOutput = "-----------------------------------------\n" +
                "| Student    | Grades               | Avg  |\n" +
                "-----------------------------------------\n" +
                "| Alice      | 90, 85, 88           | 87.7 |\n" +
                "| Bob        | 75, 80, 70           | 75.0 |\n" +
                "-----------------------------------------\n";

        // Assert that the output matches the expected output
        assertEquals(expectedOutput, outContent.toString());
    }
}
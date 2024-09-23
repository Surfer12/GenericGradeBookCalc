package dataModels;

import Displays.GradebookDisplayImpl;
import dataManipulators.ClassAverageCalculatorImpl;
import dataManipulators.SimpleGradeCalculator;
import handlers.GradeEntrySystemImpl;
import handlers.InputHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import dataManipulators.GradeCalculator;
import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;
import validators.InputValidator;

import java.util.HashSet;
import java.util.Scanner;
public class DoubleGradeBookTest {

    private DoubleGradeBook doubleGradeBook;

    @BeforeEach
    public void setUp() {
        // Initialize the DoubleGradeBook instance with necessary dependencies
        doubleGradeBook = new DoubleGradeBook(
                new StudentRegistryImpl<>(),
new InputHandlerImpl<>(new Scanner(System.in), new InputValidator<>(new Validator<String>() {}, "name")),
new InputHandlerImpl<>(new Scanner(System.in), new InputValidator<>(String.class, "name")),
                new SimpleGradeCalculator<>(),
                new GradebookDisplayImpl<>(),
                new ClassAverageCalculatorImpl<>(),
                () -> new Student<Double>(),
                new HashSet<Double>()
        );
    }

    @Test
    public void testAddStudent() {
        Student<Double> student = new Student<>();
        doubleGradeBook.addStudent(student);
        assertTrue(doubleGradeBook.getRegistry().getAllStudents().containsValue(student));
    }

    @Test
    public void testUpdateGrade() {
        Student<Double> student = new Student<>();
        doubleGradeBook.addStudent(student);
        double newGrade = 90.5;
        doubleGradeBook.updateGrade(student, newGrade);
        assertEquals(newGrade, student.getGradeValue());
    }

    @Test
    public void testRemoveStudent() {
        Student<Double> student = new Student<>();
        doubleGradeBook.addStudent(student);
        doubleGradeBook.removeStudent(student);
        assertFalse(doubleGradeBook.getRegistry().getAllStudents().containsValue(student));
    }

    // Add more tests for other methods as needed

}
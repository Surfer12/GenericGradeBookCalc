package dataModels; // Ensure this is correct

import java.util.List; // Import List
import java.util.Arrays; // Import Arrays
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import assertions
import org.junit.jupiter.api.BeforeEach; // Ensure this class exists

import dataModels.Student;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentTest {
    private Student<Integer> student;

    @BeforeEach
    void setUp() {
        student = new Student<>("John Doe");
    }

    @Test
    void testDefaultConstructor() {
        Student<Integer> defaultStudent = new Student<>();
        assertNotNull(defaultStudent.getGrades());
        assertEquals(0, defaultStudent.getGrades().size());
    }

    @Test
    void testConstructorWithName() {
        assertEquals("John Doe", student.getName());
    }

    @Test
    void testConstructorWithNameAndGrades() {
List<Integer> grades = java.util.Arrays.asList(90, 80, 70);
Student<Integer> studentWithGrades = new Student<>("Jane Doe", grades);
        assertEquals("Jane Doe", studentWithGrades.getName());
        assertEquals(grades, studentWithGrades.getGrades());
    }

    @Test
    void testSetName() {
        student.setName("Jane Doe");
        assertEquals("Jane Doe", student.getName());
    }

    @Test
    void testAddGrade() {
        student.addGrade(85);
        assertEquals(1, student.getGrades().size());
        assertEquals(85, student.getGrades().get(0));
    }

    @Test
    void testGetGrades() {
        student.addGrade(85);
        student.addGrade(90);
        List<Integer> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertEquals(85, grades.get(0));
    }
}
}

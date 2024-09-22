package dataModels; // Ensure this is correct

import dataModels.StudentImpl; // Ensure this class exists
import java.util.Optional; // Import Optional
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import assertions

public class SimpleStudentRegistryTest {
    private SimpleStudentRegistry<StudentImpl, Integer> registry; // Ensure this class exists

    @BeforeEach
    public void setUp() {
        registry = new SimpleStudentRegistry<>();
    }

    @Test
    public void testAddStudent() {
        StudentImpl student = new StudentImpl("John Doe", 90); // Ensure this class exists
        registry.addStudent(student);
        assertEquals(1, registry.countStudents());
        assertTrue(registry.getStudent("John Doe").isPresent());
    }

    // ... existing test methods ...
}
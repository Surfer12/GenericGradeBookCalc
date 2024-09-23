package dataModels;

import dataModels.StudentRegistryImpl;
import dataModels.SimpleStudentRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleStudentRegistryTest {

    private SimpleStudentRegistry<Student<Integer>, Integer> registry;

    @BeforeEach
    void setUp() {
        registry = new SimpleStudentRegistry<>();
    }

    @Test
    void testAddStudent() {
        Student student = new Student();
        registry.addStudent(student);
        assertEquals(1, registry.countStudents());
        assertTrue(registry.getStudent("John Doe").isPresent());
    }

    @Test
    void testRemoveStudent() {
        Student student = new Student("Jane Doe", 85);
        registry.addStudent(student);
        Optional<Student> removedStudent = registry.removeStudent("Jane Doe");
        assertTrue(removedStudent.isPresent());
        assertEquals("Jane Doe", removedStudent.get().getName());
        assertEquals(0, registry.countStudents());
    }

    @Test
    void testGetStudent() {
        Student student = new Student("Alice", 95);
        registry.addStudent(student);
        Optional<Student> foundStudent = registry.getStudent("Alice");
        assertTrue(foundStudent.isPresent());
        assertEquals("Alice", foundStudent.get().getName());
    }

    @Test
    void testCountStudents() {
        assertEquals(0, registry.countStudents());
    }
}

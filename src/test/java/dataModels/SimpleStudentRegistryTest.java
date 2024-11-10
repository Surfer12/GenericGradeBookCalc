package dataModels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleStudentRegistryTest {
    private SimpleStudentRegistry<Student<Integer>, Integer> registry;

    @BeforeEach
    void setUp() {
        registry = new SimpleStudentRegistry<>();
    }

    @Test
    void testAddStudent() {
        Student<Integer> student = new Student<>("John Doe");
        registry.addStudent(student);
        assertEquals(1, registry.countStudents());
        assertTrue(registry.getStudent("John Doe").isPresent());
    }

    @Test
    void testRemoveStudent() {
        Student<Integer> student = new Student<>("Jane Doe", 85);
        registry.addStudent(student);
        Optional<Student<Integer>> removedStudent = registry.removeStudent("Jane Doe");
        assertTrue(removedStudent.isPresent());
        assertEquals("Jane Doe", removedStudent.get().getName());
        assertEquals(0, registry.countStudents());
    }

    @Test
    void testGetStudent() {
        Student<Integer> student = new Student<>("Alice", 95);
        registry.addStudent(student);
        Optional<Student<Integer>> foundStudent = registry.getStudent("Alice");
        assertTrue(foundStudent.isPresent());
        assertEquals("Alice", foundStudent.get().getName());
    }

    @Test
    void testCountStudents() {
        assertEquals(0, registry.countStudents());
    }
}

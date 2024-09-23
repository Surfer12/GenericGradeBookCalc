package dataModels; // Ensure this is correct

import dataModels.StudentImpl; // Ensure this class exists
import java.util.Optional; // Import Optional
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import assertions
import java.util.Optional;

import dataModels.StudentRegistryImpl;
import dataModels.SimpleStudentRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleStudentRegistryTest {
    private SimpleStudentRegistry<StudentImpl, Integer> registry; // Ensure this class exists

    class SimpleStudentRegistryTest {

        private SimpleStudentRegistry<Student<Integer>, Integer> registry;

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

        <<<<<<<HEAD

        @Test
        void testCountStudents() {
            assertEquals(0, registry.countStudents());
        }=======

    @Test
    void testCountStudents() {
        assertEquals(0, registry.countStudents());
    }>>>>>>>491d 2 bcae0ee67f538c43b91d98fc1d715301e17
}

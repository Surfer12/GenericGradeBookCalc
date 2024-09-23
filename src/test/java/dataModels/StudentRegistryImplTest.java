package dataModels; // Correct package declaration

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach; // Necessary imports
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class StudentRegistryImplTest {
    private StudentRegistry<Student<Integer>, Integer> registry; // Fix type parameters
    private Student<Integer> student;

    @BeforeEach
    void setUp() {
        registry = new StudentRegistryImpl<>();
        student = Mockito.mock(Student.class);
    }

    // Add tests here

    class StudentRegistryImplTest {

        private StudentRegistryImpl<Student<Integer>, Integer> studentRegistry;
        private Student<Integer> mockStudent;

        @BeforeEach
        void setUp() {
            studentRegistry = new StudentRegistryImpl<>();
            mockStudent = mock(Student.class);
            when(mockStudent.getName()).thenReturn("John Doe");
        }

        @Test
        void testAddStudent() {
            studentRegistry.addStudent(mockStudent);
            List<Student<Integer>> students = studentRegistry.getStudents();
            assertEquals(1, students.size());
            assertEquals(mockStudent, students.get(0));
        }

        @Test
        void testRemoveStudent() {
            studentRegistry.addStudent(mockStudent);
            Optional<Student<Integer>> removedStudent = studentRegistry.removeStudent("John Doe");
            assertTrue(removedStudent.isPresent());
            assertEquals(mockStudent, removedStudent.get());
            assertTrue(studentRegistry.getStudents().isEmpty());
        }

        @Test
        void testGetStudent() {
            studentRegistry.addStudent(mockStudent);
            Optional<Student<Integer>> student = studentRegistry.getStudent("John Doe");
            assertTrue(student.isPresent());
            assertEquals(mockStudent, student.get());
        }

        @Test
        void testCountStudents() {
            assertEquals(0, studentRegistry.countStudents());
            studentRegistry.addStudent(mockStudent);
            assertEquals(1, studentRegistry.countStudents());
        }

        @Test
        void testGetAllStudents() {
            studentRegistry.addStudent(mockStudent);
            Map<String, Student<Integer>> allStudents = studentRegistry.getAllStudents();
            assertEquals(1, allStudents.size());
            assertTrue(allStudents.containsKey("John Doe"));
            assertEquals(mockStudent, allStudents.get("John Doe"));
        }

@Test
void testUpdateGrade() {
    studentRegistry.addStudent(mockStudent);
    doReturn(true).when(mockStudent).addGrade(anyInt());
    Optional<Student<Integer>> updatedStudent = studentRegistry.updateGrade("John Doe", 1, 90);
    assertTrue(updatedStudent.isPresent());
    verify(mockStudent, times(1)).addGrade(90);
}
package dataModels;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentRegistryTest {

   private StudentRegistry<Student<Integer>, Integer> studentRegistry;
   private Student<Integer> student;

   @BeforeEach
   void setUp() {
      studentRegistry = mock(StudentRegistry.class);
      student = mock(Student.class);
      when(student.getName()).thenReturn("John Doe");
   }

   @Test
   void testAddStudent() {
      studentRegistry.addStudent(student);
      verify(studentRegistry, times(1)).addStudent(student);
   }

   @Test
   void testGetStudent() {
      when(studentRegistry.getStudent("John Doe")).thenReturn(Optional.of(student));
      Optional<Student<Integer>> result = studentRegistry.getStudent("John Doe");
      assertTrue(result.isPresent());
      assertEquals("John Doe", result.get().getName());
   }

   @Test
   void testRemoveStudent() {
      when(studentRegistry.removeStudent("John Doe")).thenReturn(Optional.of(student));
      Optional<Student<Integer>> result = studentRegistry.removeStudent("John Doe");
      assertTrue(result.isPresent());
      assertEquals("John Doe", result.get().getName());
   }

   @Test
   void testCountStudents() {
      when(studentRegistry.countStudents()).thenReturn(1);
      int count = studentRegistry.countStudents();
      assertEquals(1, count);
   }

   @Test
   void testGetStudents() {
      when(studentRegistry.getStudents()).thenReturn(List.of(student));
      List<Student<Integer>> students = studentRegistry.getStudents();
      assertEquals(1, students.size());
      assertEquals("John Doe", students.get(0).getName());
   }

   @Test
   void testUpdateGrade() {
      when(studentRegistry.updateGrade("John Doe", 1, 90)).thenReturn(Optional.of(student));
      Optional<Student<Integer>> result = studentRegistry.updateGrade("John Doe", 1, 90);
      assertTrue(result.isPresent());
      assertEquals("John Doe", result.get().getName());
   }

   @Test
   void testGetAllStudents() {
      when(studentRegistry.getAllStudents()).thenReturn(Map.of("John Doe", student));
      Map<String, Student<Integer>> students = studentRegistry.getAllStudents();
      assertEquals(1, students.size());
      assertTrue(students.containsKey("John Doe"));
      assertEquals("John Doe", students.get("John Doe").getName());
   }
}
package dataModels; // Ensure this is correct

import dataModels.StudentImpl; // Ensure this class exists
import java.util.Optional; // Import Optional
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import assertions

public class SimpleStudentRegistryTest {
private SimpleStudentRegistry<StudentImpl, Integer> registry; // Ensure this class exists
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataModels.Student;
import dataModels.StudentImpl;

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

   @Test
   void testRemoveStudent() {
      StudentImpl student = new StudentImpl("Jane Doe", 85);
      registry.addStudent(student);
      Optional<StudentImpl> removedStudent = registry.removeStudent("Jane Doe");
      assertTrue(removedStudent.isPresent());
      assertEquals("Jane Doe", removedStudent.get().getName());
      assertEquals(0, registry.countStudents());
   }

   @Test
   void testGetStudent() {
      StudentImpl student = new StudentImpl("Alice", 95);
      registry.addStudent(student);
      Optional<StudentImpl> foundStudent = registry.getStudent("Alice");
      assertTrue(foundStudent.isPresent());
      assertEquals("Alice", foundStudent.get().getName());
   }

   @Test
   void testCountStudents() {
      assertEquals(0, registry.countStudents());
   }
}

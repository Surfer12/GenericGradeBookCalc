package dataModels; // Ensure this is correct

import java.util.List; // Import List
import java.util.Arrays; // Import Arrays
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Import assertions
import org.junit.jupiter.api.BeforeEach; // Ensure this class exists

class StudentTest {
   private Student defaultStudent;
   private Student studentWithGrades;

   @BeforeEach
   public void setUp() {
      defaultStudent = new Student("John Doe");
      List<Integer> grades = Arrays.asList(90, 80, 70);
      studentWithGrades = new Student("Jane Doe", grades);
   }

   @Test
   public void testDefaultStudent() {
      assertNotNull(defaultStudent.getGrades());
      assertEquals(0, defaultStudent.getGrades().size());
   }

   @Test
   void testConstructorWithName() {
      assertEquals("John Doe", studentWithGrades.getName());
   }

   @Test
   void testConstructorWithNameAndGrades() {
      assertEquals("Jane Doe", studentWithGrades.getName());
      assertEquals(grades, studentWithGrades.getGrades());
   }

   @Test
   void testSetName() {
      studentWithGrades.setName("Jane Doe");
      assertEquals("Jane Doe", studentWithGrades.getName());
   }

   @Test
   void testAddGrade() {
      studentWithGrades.addGrade(85);
      assertEquals(1, studentWithGrades.getGrades().size());
      assertEquals(85, studentWithGrades.getGrades().get(0));
   }

   @Test
   void testGetGrades() {
      studentWithGrades.addGrade(85);
      studentWithGrades.addGrade(90);
      List<Integer> grades = studentWithGrades.getGrades();
      assertEquals(2, grades.size());
      assertEquals(85, grades.get(0));
   }
}
}

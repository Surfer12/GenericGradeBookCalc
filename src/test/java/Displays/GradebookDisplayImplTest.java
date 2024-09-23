package Displays;

import dataModels.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class GradebookDisplayImplTest {

    private GradebookDisplayImpl<Student<?>> gradebookDisplay;
    private Student<?> student1;
    private Student<?> student2;

    @BeforeEach
    void setUp() {
        gradebookDisplay = new GradebookDisplayImpl<>();
        student1 = mock(Student.class);
        student2 = mock(Student.class);

        when(student1.getName()).thenReturn("John Doe");
        when(student1.getGradesAsString()).thenReturn("A, B, C");
        when(student1.getAverage()).thenReturn(85.0);

        when(student2.getName()).thenReturn("Jane Smith");
        when(student2.getGradesAsString()).thenReturn("B, B, A");
        when(student2.getAverage()).thenReturn(88.0);
    }

    @Test
    void testDisplay() {
        List<Student<?>> students = Arrays.asList(student1, student2);
        gradebookDisplay.display(students);

        verify(student1, times(1)).getName();
        verify(student1, times(1)).getGradesAsString();
        verify(student1, times(1)).getAverage();

        verify(student2, times(1)).getName();
        verify(student2, times(1)).getGradesAsString();
        verify(student2, times(1)).getAverage();
    }
}
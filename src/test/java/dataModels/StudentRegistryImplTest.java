package dataModels; // Correct package declaration
package dataModels;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach; // Necessary imports
import org.mockito.Mockito;

class StudentRegistryImplTest {
    private StudentRegistry<Student<Integer>, Integer> registry; // Fix type parameters
    private Student<Integer> student;

    @BeforeEach
    void setUp() {
        registry = new StudentRegistryImpl<>();
        student = Mockito.mock(Student.class);
    }

    // Add tests here

}
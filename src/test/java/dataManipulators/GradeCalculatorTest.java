package dataManipulators; // Ensure this is correct

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*; // Import Mockito
import static org.junit.jupiter.api.Assertions.*; // Import assertions
import dataModels.StudentImpl; // Ensure this class exists
import handlers.GradeProcessor; // Updated import

public class GradeCalculatorTest {
    private GradeProcessor<StudentImpl, Integer> gradeCalculator; // Ensure this class exists

    @BeforeEach
    public void setUp() {
        gradeCalculator = mock(GradeProcessor.class);
    }

    // ... existing test methods ...
}
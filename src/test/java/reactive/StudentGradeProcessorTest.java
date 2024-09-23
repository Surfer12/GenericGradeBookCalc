package reactive; // Ensure this is correct

import org.junit.jupiter.api.Test; // Necessary imports
import reactor.core.publisher.Flux; // Import Flux
import static org.mockito.Mockito.*; // Import Mockito
import reactor.test.StepVerifier; // Import StepVerifier
import org.junit.jupiter.api.BeforeEach; // Ensure this class exists

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;

public class StudentGradeProcessorTest {

   private GradeStrategy mockStrategy;

   @BeforeEach
   public void setUp() {
      mockStrategy = mock(GradeStrategy.class);
   }

   @Test
   public void testProcessGrades() {
      StudentGradeProcessor processor = new StudentGradeProcessor(mockStrategy);
      Flux<Integer> grades = Flux.just(95, 80, 65);
      when(mockStrategy.calculateGrade(95)).thenReturn("A"); // Ensure this method exists
      when(mockStrategy.calculateGrade(80)).thenReturn("B");
      when(mockStrategy.calculateGrade(65)).thenReturn("C");

      StepVerifier.create(processor.processGrades(grades))
            .expectNext("A", "B", "C")
            .verifyComplete();
   }

   // ... existing test methods ...
}
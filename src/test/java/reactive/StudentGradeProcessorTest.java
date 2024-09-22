package test.java.reactive; // Fix the package declaration

import org.junit.jupiter.api.Test; // Necessary imports
import reactor.core.publisher.Flux;
import static org.mockito.Mockito.*;

public class StudentGradeProcessorTest {

   @Test
   public void testProcessGrades() {
      // Mock the GradeStrategy
      GradeStrategy mockStrategy = mock(GradeStrategy.class);

      // Define the behavior of the mock
      when(mockStrategy.calculateGrade(90)).thenReturn(Flux.just("A")); // Change Mono to Flux
      when(mockStrategy.calculateGrade(80)).thenReturn(Flux.just("B"));
      when(mockStrategy.calculateGrade(70)).thenReturn(Flux.just("C"));
      when(mockStrategy.calculateGrade(60)).thenReturn(Flux.just("D"));
      when(mockStrategy.calculateGrade(50)).thenReturn(Flux.just("F"));

      // Create the processor with the mock strategy
      StudentGradeProcessor processor = new StudentGradeProcessor(mockStrategy);

      // Define the grades to be processed
      Flux<Integer> grades = Flux.just(85, 70, 55, 90, 40);

      // Process the grades and verify the results
      StepVerifier.create(processor.processGrades(grades))
            .expectNext("Pass")
            .expectNext("Pass")
            .expectNext("Fail")
            .expectNext("Pass")
            .expectNext("Fail")
            .verifyComplete();

      // Verify that the strategy was applied correctly
      verify(mockStrategy).applyStrategy(85);
      verify(mockStrategy).applyStrategy(70);
      verify(mockStrategy).applyStrategy(55);
      verify(mockStrategy).applyStrategy(90);
      verify(mockStrategy).applyStrategy(40);
   }
}
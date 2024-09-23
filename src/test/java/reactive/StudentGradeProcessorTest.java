package reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class StudentGradeProcessorTest {

    @Test
    public void testProcessGrades() {
        // Mock the GradeStrategy
        GradeStrategy mockStrategy = mock(GradeStrategy.class);

        // Define the behavior of the mock
        when(mockStrategy.applyStrategy(85)).thenAnswer(invocation -> Flux.just("Pass"));
        when(mockStrategy.applyStrategy(70)).thenAnswer(invocation -> Flux.just("Pass"));
        when(mockStrategy.applyStrategy(55)).thenAnswer(invocation -> Flux.just("Fail"));
        when(mockStrategy.applyStrategy(90)).thenAnswer(invocation -> Flux.just("Pass"));
        when(mockStrategy.applyStrategy(40)).thenAnswer(invocation -> Flux.just("Fail"));

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
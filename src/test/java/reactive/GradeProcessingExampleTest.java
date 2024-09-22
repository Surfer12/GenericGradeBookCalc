import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;

package test.java.reactive; // Fix the package declaration

public class GradeProcessingExampleTest {

   private GradeStrategy letterStrategy;
   private GradeStrategy passFailStrategy;
   private StudentGradeProcessor letterProcessor;
   private StudentGradeProcessor passFailProcessor;
   private GradeProcessingExample gradeProcessingExample;

   @BeforeEach
   public void setUp() {
      letterStrategy = mock(GradeStrategy.class);
      passFailStrategy = mock(GradeStrategy.class);
      letterProcessor = new StudentGradeProcessor(letterStrategy);
      passFailProcessor = new StudentGradeProcessor(passFailStrategy);
      gradeProcessingExample = new GradeProcessingExample(letterStrategy, passFailStrategy);
   }

   @Test
   public void testLetterGradesProcessing() {
      Flux<Integer> grades = Flux.just(95, 80, 65, 50, 75);
      when(letterStrategy.calculateGrade(95)).thenReturn("A");
      when(letterStrategy.calculateGrade(80)).thenReturn("B");
      when(letterStrategy.calculateGrade(65)).thenReturn("C");
      when(letterStrategy.calculateGrade(50)).thenReturn("D");
      when(letterStrategy.calculateGrade(75)).thenReturn("C");

      StepVerifier.create(letterProcessor.processGrades(grades))
            .expectNext("A", "B", "C", "D", "C")
            .verifyComplete();
   }

   @Test
   public void testPassFailGradesProcessing() {
      Flux<Integer> grades = Flux.just(95, 80, 65, 50, 75);
      when(passFailStrategy.calculateGrade(95)).thenReturn("Pass");
      when(passFailStrategy.calculateGrade(80)).thenReturn("Pass");
      when(passFailStrategy.calculateGrade(65)).thenReturn("Pass");
      when(passFailStrategy.calculateGrade(50)).thenReturn("Fail");
      when(passFailStrategy.calculateGrade(75)).thenReturn("Pass");

      StepVerifier.create(passFailProcessor.processGrades(grades))
            .expectNext("Pass", "Pass", "Pass", "Fail", "Pass")
            .verifyComplete();
   }
}
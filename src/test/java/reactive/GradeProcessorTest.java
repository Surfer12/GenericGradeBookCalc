package reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


public class GradeProcessorTest {

   @Test
   public void testGradeProcessor() {
      GradeStrategy strategy = new LetterGradeStrategy();

      Flux<Integer> grades = Flux.just(95, 82, 67, 54, 88);

      Flux<String> letterGrades = grades.flatMap(strategy::applyStrategy);

      StepVerifier.create(letterGrades)
            .expectNext("A")
            .expectNext("B")
            .expectNext("D")
            .expectNext("F")
            .expectNext("B")
            .verifyComplete();
   }
}